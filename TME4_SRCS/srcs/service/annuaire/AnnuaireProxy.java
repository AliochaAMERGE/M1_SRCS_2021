package srcs.service.annuaire;

import srcs.service.ClientProxy;
import srcs.service.MyProtocolException;

public class AnnuaireProxy extends ClientProxy implements Annuaire {

	public AnnuaireProxy(String name, int port) {
		super(name, port);
	}

	@Override
	public String lookup(String name)
	{
		Object[] args = new Object[1];
		args[0] = name;

		return (String) super.invokeService("lookup", args);

	}

	@Override
	public void bind(String name, String value)
	{
		Object[] args = new Object[2];
		args[0] = name;
		args[1] = value;

		super.invokeService("bind", args);
		return;

	}

	@Override
	public void unbind(String name)
	{
		Object[] args = new Object[1];
		args[0] = name;

		super.invokeService("unbind", args);
		return;

	}

}
