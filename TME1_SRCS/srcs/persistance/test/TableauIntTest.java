package srcs.persistance.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static srcs.persistance.PersistanceTools.loadArrayInt;
import static srcs.persistance.PersistanceTools.saveArrayInt;

import java.io.IOException;

import org.junit.Test;
public class TableauIntTest {

	@Test
	public void testTableauInt() {
		try {
			String fichier = "/tmp/tab";
			int[] test = new int[] {0,4,5,6000,-2,-27543};
			saveArrayInt(fichier, test);
			int[] tab = loadArrayInt(fichier);
			assertArrayEquals(test, tab);			
		}catch(IOException e) {
			assertTrue(false);
		}
	}
}
