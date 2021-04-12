package srcs.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class ClientProxy {

	public final String name;
	public final int port;

	public ClientProxy(String name, int port) {
		this.name = name;
		this.port = port;
	}

	public String getName()
	{
		return name;
	}

	public int getPort()
	{
		return port;
	}

	protected Object invokeService(String name, Object[] params)
	{

		try (Socket client = new Socket(getName(), getPort()))
		{
			try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream()))
			{
				try (ObjectInputStream in = new ObjectInputStream(client.getInputStream()))
				{
					out.writeUTF(name);

					out.writeInt(params.length);
					for (int i = 0; i < params.length; i++)
					{
						out.writeObject(params[i]);
					}
					out.flush();
					Object obj = in.readObject();

					if (obj instanceof VoidResponse)
					{
						client.close();
						return new VoidResponse();
					}

					if (obj instanceof MyProtocolException)
					{
						client.close();
						throw new MyProtocolException();
					}
					client.close();
					return obj;
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MyProtocolException e)
				{
					e.printStackTrace();
				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return new MyProtocolException();
	}
}
