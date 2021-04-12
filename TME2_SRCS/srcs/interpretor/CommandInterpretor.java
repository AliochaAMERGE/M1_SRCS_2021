package srcs.interpretor;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CommandInterpretor {
	private Map<String, Class<? extends Command>> c_map;

	public CommandInterpretor() {
		this.c_map = new HashMap<String, Class<? extends Command>>();
		c_map.put("cat", Cat.class);
		c_map.put("echo", Echo.class);
		c_map.put("deploy", Deploy.class);
		c_map.put("undeploy", UnDeploy.class);
		c_map.put("save", Save.class);
	}

	public CommandInterpretor(String file) {
		this();

		String commandName, className;

		try {

			ObjectInputStream is = new MyClassLoader(new FileInputStream(file));

			while(is.available() > 0) {
				commandName = is.readUTF();
				className = is.readUTF();

				if(! c_map.containsKey(commandName)) {
					URLClassLoader ucl = new URLClassLoader(new URL[] {(URL) is.readObject()});
					@SuppressWarnings("unchecked")
					Class<? extends Command> com = (Class<? extends Command>) ucl.loadClass(className);
					c_map.put(commandName, com);
					ucl.close();
				}
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Class<? extends Command> getClassOf(String args) {
		if (c_map.containsKey(args)) {
			return c_map.get(args);
		} else {
			return null;
		}
	}

	public void perform(String args, PrintStream out) throws Exception {

		if (args == "")
			return;

		List<String> l_args = new ArrayList<String>();
		StringTokenizer stk = new StringTokenizer(args);

		while (stk.hasMoreTokens()) {
			l_args.add(stk.nextToken());
		}

		Class<? extends Command> com = getClassOf(l_args.get(0));

		if (com == null)
			throw new CommandNotFoundException();

		boolean isIn = false;

		for (Class<?> com_iter : this.getClass().getDeclaredClasses()) {
			if (com.toString().contentEquals(com_iter.toString())) {
				Constructor<? extends Command> ctr = com.getConstructor(CommandInterpretor.class, List.class);
				Command cd = (Command) ctr.newInstance(this, l_args);
				cd.execute(out);
				isIn = true;
			}
		}

		if (isIn == false) {
			Constructor<? extends Command> ctr = com.getConstructor(List.class);
			Command cd = (Command) ctr.newInstance(l_args);
			cd.execute(out);
		}
	}

	public class Deploy implements Command {

		List<String> args;

		public Deploy(List<String> args) {
			this.args = args;
		}

		@Override
		public void execute(PrintStream out) {

			File file = new File(args.get(2));

			// arg0 deploy
			// arg1 non de la commande
			// arg2 chemin qui mene a la classe
			// arg3 nom de la classe

			if (!file.exists() || !file.isDirectory() || c_map.containsKey(args.get(1)) || args.size() != 4) {
				throw new IllegalArgumentException();
			}
			if (c_map.containsKey(args.get(1))) {
				throw new IllegalArgumentException();
			}

			String commandName = args.get(1);
			String path = args.get(2);
			String className = args.get(3);

			URL url;

			try {

				url = new File(path).toURI().toURL();

				URLClassLoader ucl = URLClassLoader.newInstance(new URL[] { url });
				Class<? extends Command> com = ucl.loadClass(className).asSubclass(Command.class);

				ucl.close();

				c_map.put(commandName, com);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public class UnDeploy implements Command {

		List<String> args;

		public UnDeploy(List<String> args) {

			this.args = args;

		}

		@Override
		public void execute(PrintStream out) {

			if (args.size() != 2)
				throw new IllegalArgumentException();
			// if map don t contains our command
			if (!c_map.containsKey(args.get(1))) {
				throw new IllegalArgumentException();
			} else {
				c_map.remove(args.get(1));
			}
		}

	}

	public class Save implements Command {

		private List<String> args;

		public Save(List<String> args) {
			this.args = args;
		}

		public void execute(PrintStream out) {

			if (args.size() != 2)
				throw new IllegalArgumentException();

			try {

				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(args.get(1)));
				
				for (String commandName : c_map.keySet()) {
					String path = c_map.get(commandName).getProtectionDomain().getCodeSource().getLocation().getPath();
					os.writeUTF(commandName);
					os.writeUTF(c_map.get(commandName).getCanonicalName());
					os.writeObject(new File(path).toURI().toURL());
				}
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
