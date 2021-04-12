package srcs.persistance.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import srcs.banque.Banque;
import srcs.banque.Client;
import srcs.banque.Compte;
import srcs.persistance.PersistanceTools;
import srcs.persistance.Sauvegardable;

public class Banque2Clients2ComptesTest {

	@Test
	public void test() {
				
		Client cli1 = new Client("client1", new Compte("cpt1"));
		Client cli2 = new Client("client2", new Compte("cpt2"));
				
		Banque banque = new Banque();
		banque.addNewClient(cli1);
		banque.addNewClient(cli2);
		banque.getClient("client1").getCompte().crediter(10);
		banque.getClient("client2").getCompte().debiter(2);
		assertEquals(10,banque.getClient("client1").getCompte().getSolde(),0);
		assertEquals(-2,banque.getClient("client2").getCompte().getSolde(),0);
		assertEquals(2,banque.nbClients());
		assertEquals(2,banque.nbComptes());
			
		String fichier="/tmp/banque";
		try {
			PersistanceTools.save(fichier, banque);
			Sauvegardable s  = PersistanceTools.load(fichier); 
			assertTrue(s instanceof Banque);
			banque = (Banque) s;
			assertEquals(10,banque.getClient("client1").getCompte().getSolde(),0);
			assertEquals(-2,banque.getClient("client2").getCompte().getSolde(),0);
			assertEquals(2,banque.nbClients());
			assertEquals(2,banque.nbComptes());
			banque.getClient("client1").getCompte().crediter(5);
			banque.getClient("client2").getCompte().debiter(2);
			assertEquals(15,banque.getClient("client1").getCompte().getSolde(),0);
			assertEquals(-4,banque.getClient("client2").getCompte().getSolde(),0);
			
		} catch (IOException | ReflectiveOperationException e) {
			assertTrue(false);
			e.printStackTrace();
		}
				
	}
	
	
	

}
