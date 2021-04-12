package srcs.interpretor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class Cat implements Command {
	
	List<String> args;
	
	public Cat(List<String>  args) {
		if(args.size() <= 1)
			throw new IllegalArgumentException();
		
		File f = new File(args.get(1));
		
		if(!f.exists() || f.isDirectory()) {
			throw new IllegalArgumentException();
		}
		this.args = args;
	}

	@Override
	public void execute(PrintStream out) {
		// TODO Auto-generated method stub
			
		DataInputStream in;
		try {
			in = new DataInputStream(new FileInputStream(args.get(1)));
			BufferedReader buf = new BufferedReader(new InputStreamReader(in));
			String tmp;
			while((tmp = buf.readLine()) != null) {
				out.println(tmp);
			}
			
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
