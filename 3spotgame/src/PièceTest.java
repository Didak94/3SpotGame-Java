import static org.junit.Assert.*;

import org.junit.Test;


public class PièceTest {

	@Test
	public void test1() {
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Pièce neutre = new Pièce("W");
		assertTrue(rouge.getCouleur() == "R");
		assertTrue(bleue.getCouleur() == "B");
		assertTrue(neutre.getCouleur() == "W");
	}

	@Test
	public void test2() {
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Pièce neutre = new Pièce("W");
		assertTrue(rouge.piècePrésente(0, 1) == true);
		assertTrue(rouge.piècePrésente(0, 2) == true);
		assertTrue(neutre.piècePrésente(1, 1) == true);
		assertTrue(neutre.piècePrésente(1, 2) == true);
		assertTrue(bleue.piècePrésente(2, 1) == true);
		assertTrue(bleue.piècePrésente(2, 2) == true);
	}
	
	@Test
	public void test3() {
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Pièce neutre = new Pièce("W");
		Plateau p = new Plateau();
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(rouge, neutre, bleue);
		rouge.movePièce("3");
		System.out.println(p.toString(rouge, neutre, bleue));
		//assertTrue(rouge.getCoordX(0, 0) == true);
		//assertTrue(rouge.getCoordY(0, 1) == true);
		p.coordDispo(neutre, rouge, bleue);
		neutre.movePièce("2");
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(bleue, neutre, rouge);
		bleue.movePièce("2");
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(neutre, rouge, bleue);
		neutre.movePièce("3");
		System.out.println(p.toString(rouge, neutre, bleue));
	}
}
