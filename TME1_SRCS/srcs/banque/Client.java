package srcs.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import srcs.persistance.Sauvegardable;

public class Client implements Sauvegardable{

	
	private final String nom;
	private final Compte compte;

	
	public Client(String nom, Compte compte) {
		this.nom=nom;
		this.compte=compte;

	}
	
	public Client(InputStream in) throws IOException {
		DataInputStream is = new DataInputStream(in);
		this.nom = is.readUTF();
		this.compte = new Compte(is);
	}
		
	public String getNom() {
		return nom;
	}


	public Compte getCompte() {
		return compte;
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Client other= (Client) o;
		return other.nom.equals(nom);
	}

	@Override
	public void save(OutputStream out) throws IOException {
		DataOutputStream os = new DataOutputStream(out);
		os.writeUTF(this.getNom());
		compte.save(os);
	}
	
}
