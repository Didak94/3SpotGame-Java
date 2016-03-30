import static org.junit.Assert.*;

import org.junit.Test;


public class Pi�ceTest {

	@Test
	public void test1() {
		Pi�ce rouge = new Pi�ce("R");
		Pi�ce bleue = new Pi�ce("B");
		Pi�ce neutre = new Pi�ce("W");
		assertTrue(rouge.getCouleur() == "R");
		assertTrue(bleue.getCouleur() == "B");
		assertTrue(neutre.getCouleur() == "W");
	}

	@Test
	public void test2() {
		Pi�ce rouge = new Pi�ce("R");
		Pi�ce bleue = new Pi�ce("B");
		Pi�ce neutre = new Pi�ce("W");
		assertTrue(rouge.pi�cePr�sente(0, 1) == true);
		assertTrue(rouge.pi�cePr�sente(0, 2) == true);
		assertTrue(neutre.pi�cePr�sente(1, 1) == true);
		assertTrue(neutre.pi�cePr�sente(1, 2) == true);
		assertTrue(bleue.pi�cePr�sente(2, 1) == true);
		assertTrue(bleue.pi�cePr�sente(2, 2) == true);
	}
	
	@Test
	public void test3() {
		Pi�ce rouge = new Pi�ce("R");
		Pi�ce bleue = new Pi�ce("B");
		Pi�ce neutre = new Pi�ce("W");
		Plateau p = new Plateau();
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(rouge, neutre, bleue);
		rouge.movePi�ce("3");
		System.out.println(p.toString(rouge, neutre, bleue));
		//assertTrue(rouge.getCoordX(0, 0) == true);
		//assertTrue(rouge.getCoordY(0, 1) == true);
		p.coordDispo(neutre, rouge, bleue);
		neutre.movePi�ce("2");
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(bleue, neutre, rouge);
		bleue.movePi�ce("2");
		System.out.println(p.toString(rouge, neutre, bleue));
		p.coordDispo(neutre, rouge, bleue);
		neutre.movePi�ce("3");
		System.out.println(p.toString(rouge, neutre, bleue));
	}
}
