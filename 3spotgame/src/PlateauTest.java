import static org.junit.Assert.*;

import org.junit.Test;


public class PlateauTest {

	@Test
	public void test1() {
		new Plateau();
		assertTrue(Plateau.getAireDeJeu(1, 2).equals("W"));
	}

	@Test
	public void test2() {
		Pi�ce rouge = new Pi�ce("R");
		Pi�ce bleue = new Pi�ce("B");
		Plateau p = new Plateau();
		Joueur joueur1 = new Joueur(rouge);
		Joueur joueur2 = new Joueur(bleue);
		
		assertTrue(!p.partieTermin�e(joueur1, joueur2));
		assertTrue(Plateau.getAireDeJeu(2, 2).equals("B"));
		assertTrue(Plateau.getAireDeJeu(0, 0).equals("\0"));
	}
	
	@Test
	public void test3() {
		Pi�ce rouge = new Pi�ce("R");
		Pi�ce bleue = new Pi�ce("B");
		Pi�ce neutre = new Pi�ce("W");
		Plateau p = new Plateau();
		Joueur joueur1 = new Joueur(rouge);
		Joueur joueur2 = new Joueur(bleue);
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(rouge, neutre, bleue);
		
		assertTrue(!p.partieTermin�e(joueur1, joueur2));
		assertTrue(Plateau.getAireDeJeu(2, 2).equals("B"));
	}
}
