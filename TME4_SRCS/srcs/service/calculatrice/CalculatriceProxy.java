package srcs.service.calculatrice;

import srcs.service.ClientProxy;
import srcs.service.MyProtocolException;

public class CalculatriceProxy extends ClientProxy implements Calculatrice {

	public CalculatriceProxy(String name, int port) {
		super(name, port);
	}

	@Override
	public Integer add(Integer x, Integer y)
	{
		Object[] args = new Object[2];
		args[0] = x;
		args[1] = y;

		return (Integer) super.invokeService("add", args);
	}

	@Override
	public Integer sous(Integer x, Integer y)
	{
		Object[] args = new Object[2];
		args[0] = x;
		args[1] = y;

		return (Integer) super.invokeService("sous", args);

	}

	@Override
	public Integer mult(Integer x, Integer y)
	{
		Object[] args = new Object[2];
		args[0] = x;
		args[1] = y;

		return (Integer) super.invokeService("mult", args);

	}

	@Override
	public ResDiv div(Integer x, Integer y)
	{
		Object[] args = new Object[2];
		args[0] = x;
		args[1] = y;

		return (ResDiv) super.invokeService("div", args);

	}

}
