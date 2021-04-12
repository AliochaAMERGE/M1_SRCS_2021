package srcs.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public interface AppelDistant extends Service {

	public default void execute(Socket connexion)
	{

		try
		{
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connexion.getOutputStream());

			String comName = in.readUTF();

			int nb_params = in.readInt();

			Class<?>[] args_tab = new Class<?>[nb_params];

			Object[] obj_tab = new Object[nb_params];

			for (int i = 0; i < nb_params; i++)
			{
				obj_tab[i] = in.readObject();
				args_tab[i] = obj_tab[i].getClass();
			}

			Method meth = getClass().getDeclaredMethod(comName, args_tab);

			Object obj = meth.invoke(this, obj_tab);

			if (obj instanceof Void)
			{
				out.writeObject(new VoidResponse());
			} else
			{
				out.writeObject(obj);
			}

			out.flush();
			out.close();
			in.close();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
