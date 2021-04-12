package srcs.service.calculatrice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import srcs.service.EtatGlobal;
import srcs.service.MyProtocolException;
import srcs.service.Service;

@EtatGlobal
public class CalculatriceService implements Service, Calculatrice {

	public Integer x, y;

	public CalculatriceService() {
	}

	@Override
	public synchronized void execute(Socket connexion) {
		
		ObjectInputStream in;
		ObjectOutputStream out;
		
		try {
			in = new ObjectInputStream(connexion.getInputStream());
			out = new ObjectOutputStream(connexion.getOutputStream());

			String comName = in.readUTF();

			this.x = in.readInt();
			this.y = in.readInt();

			if (comName.equals("add")) {
				out.writeObject(add(x, y));
			} else if (comName.equals("sous")) {
				out.writeObject(sous(x, y));
			} else if (comName.equals("mult")) {
				out.writeObject(mult(x, y));
			} else if (comName.equals("div")) {
				out.writeObject(div(x, y));
			} else {
//				MyProtocolException e = new MyProtocolException();
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
	public synchronized Integer add(Integer x, Integer y) {
		return x + y;
	}

	@Override
	public synchronized Integer sous(Integer x, Integer y) {
		return x - y;
	}

	@Override
	public synchronized Integer mult(Integer x, Integer y) {
		return x * y;
	}

	@Override
	public synchronized ResDiv div(Integer x, Integer y) {
		return new ResDiv(x, y);
	}

}
