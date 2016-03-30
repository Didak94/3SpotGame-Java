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
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Plateau p = new Plateau();
		Joueur joueur1 = new Joueur(rouge);
		Joueur joueur2 = new Joueur(bleue);
		
		assertTrue(!p.partieTerminée(joueur1, joueur2));
		assertTrue(Plateau.getAireDeJeu(2, 2).equals("B"));
		assertTrue(Plateau.getAireDeJeu(0, 0).equals("\0"));
	}
	
	@Test
	public void test3() {
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Pièce neutre = new Pièce("W");
		Plateau p = new Plateau();
		Joueur joueur1 = new Joueur(rouge);
		Joueur joueur2 = new Joueur(bleue);
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(rouge, neutre, bleue);
		
		assertTrue(!p.partieTerminée(joueur1, joueur2));
		assertTrue(Plateau.getAireDeJeu(2, 2).equals("B"));
	}
}
