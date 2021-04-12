package srcs.persistance.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static srcs.persistance.PersistanceTools.loadCompte;
import static srcs.persistance.PersistanceTools.saveCompte;

import java.io.IOException;

import org.junit.Test;

import srcs.banque.Compte;
public class CompteTest {
	
	@Test
	public void testCompte() {
		try {
			String fichier = "/tmp/compte";
			Compte cpt = new Compte("cpt1");
			cpt.crediter(5);
			cpt.debiter(2);
			assertEquals(3,cpt.getSolde(),0);
			saveCompte(fichier, cpt);
			Compte bis = loadCompte(fichier);
			assertEquals(cpt, bis);
			assertEquals(3,bis.getSolde(),0);
		}catch(IOException e) {
			assertTrue(false);
		}
	}
}
