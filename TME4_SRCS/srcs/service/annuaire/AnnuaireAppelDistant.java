package srcs.service.annuaire;

import java.util.HashMap;

import srcs.service.AppelDistant;
import srcs.service.EtatGlobal;
@EtatGlobal
public class AnnuaireAppelDistant implements Annuaire, AppelDistant {

	public HashMap<String, String> map;

	public AnnuaireAppelDistant() {
		map = new HashMap<String, String>();
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
