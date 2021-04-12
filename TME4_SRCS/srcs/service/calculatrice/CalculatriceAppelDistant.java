package srcs.service.calculatrice;

import srcs.service.AppelDistant;
import srcs.service.EtatGlobal;
@EtatGlobal
public class CalculatriceAppelDistant implements AppelDistant, Calculatrice {

	public Integer x, y;

	public CalculatriceAppelDistant() {
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
