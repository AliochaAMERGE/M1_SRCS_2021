package srcs.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import srcs.persistance.Sauvegardable;

public class Compte implements Sauvegardable {

	private final String id;
	private double solde;

	public Compte(String id) {
		this.id = id;
		this.solde = 0.0;
	}

	public Compte(InputStream in) throws IOException {
		DataInputStream is = new DataInputStream(in);
		id = is.readUTF();
		solde = is.readDouble();
	}

	public String getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void debiter(double montant) {
		solde -= montant;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Compte))
			return false;
		Compte other = (Compte) o;
		return other.id.equals(id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public void save(OutputStream out) throws IOException {

		DataOutputStream os = new DataOutputStream(out);
		os.writeUTF(this.getId());
		os.writeDouble(this.getSolde());

	}

}
