package srcs.service.annuaire;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import srcs.service.EtatGlobal;
import srcs.service.MyProtocolException;
import srcs.service.Service;
import srcs.service.VoidResponse;

@EtatGlobal
public class AnnuaireService implements Annuaire, Service {

	public HashMap<String, String> map;

	public AnnuaireService() {
		map = new HashMap<String, String>();
	}

	@Override
	public synchronized void execute(Socket connexion) {

		ObjectInputStream in;
		ObjectOutputStream out;

		try {
			in = new ObjectInputStream(connexion.getInputStream());
			out = new ObjectOutputStream(connexion.getOutputStream());

			String comName = in.readUTF();

			if (comName.equals("lookup")) {
				out.writeObject(lookup(in.readUTF()));
			} else if (comName.equals("bind")) {
				bind(in.readUTF(), in.readUTF());
				out.writeObject(new VoidResponse());
			} else if (comName.equals("unbind")) {
				unbind(in.readUTF());
				out.writeObject(new VoidResponse());
			} else {
				out.writeObject(new MyProtocolException());
			}

			out.flush();
			out.close();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized String lookup(String name) {
		if (map.containsKey(name))
			return map.get(name);
		else
			return "";
	}

	@Override
	public synchronized void bind(String name, String value) {
		map.put(name, value);
		return;
	}

	@Override
	public synchronized void unbind(String name) {
		map.remove(name);
		return;
	}

}
