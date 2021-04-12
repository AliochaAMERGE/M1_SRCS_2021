package srcs.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import srcs.banque.Compte;

public class PersistanceTools {

	public static void saveArrayInt(String f, int[] tab) throws IOException {

		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		for (int data : tab) {
			out.writeInt(data);
		}
		out.close();
	}

	public static int[] loadArrayInt(String fichier) throws IOException {

		List<Integer> line = new ArrayList<Integer>();
		DataInputStream in = new DataInputStream(new FileInputStream(fichier));

		while ((in.available()) != 0) {
			line.add(in.readInt());
		}
		int tab[] = new int[line.size()];
		for (int i = 0; i < line.size(); i++) {
			tab[i] = line.get(i);
		}
		in.close();
		return tab;
	}
	
	public static void saveCompte(String f, Compte e) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		e.save(out);
		out.close();
	}
	
	public static Compte loadCompte(String f) throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(f));
		Compte e = new Compte(in);
		in.close();
		return e;
	}
	
	public static void save(String fichier, Sauvegardable s) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fichier));
		out.writeUTF(s.getClass().getCanonicalName());
		s.save(out);
		out.close();
	}
	
	public static Sauvegardable load(String fichier) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		DataInputStream in = new DataInputStream(new FileInputStream(fichier));
		
		String className = in.readUTF();
		Class<?extends Sauvegardable> c = Class.forName(className).asSubclass(Sauvegardable.class);
		
		Constructor<? extends Sauvegardable> cstr = c.getConstructor(InputStream.class);
		
		Sauvegardable s = cstr.newInstance(in);
		
		in.close();
		return s;
	}
}