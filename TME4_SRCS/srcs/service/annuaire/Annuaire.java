package srcs.service.annuaire;

public interface Annuaire {
	
	public String lookup(String name);
	
	public void bind(String name, String value);
	
	public void unbind(String name);

}
