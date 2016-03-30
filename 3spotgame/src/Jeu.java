import java.util.Scanner;

/**Programme qui permet de jouer virtuellement au 3 Spot Game*/
public class Jeu {
	
	public static void main(String[] args) {
		Plateau p = new Plateau();
		Pièce rouge = new Pièce("R");
		Pièce bleue = new Pièce("B");
		Pièce neutre = new Pièce("W");
		Joueur joueur1 = new Joueur(rouge);
		Joueur joueur2 = new Joueur(bleue);
		Scanner sc = new Scanner(System.in);
		int nbTours = 1;
		System.out.println("Let's the match begin !!!\n");
		while (!p.partieTerminée(joueur1, joueur2)) {
			if (nbTours%2 == 1) {
				System.out.println("Au tour du joueur 1\n");
				System.out.println(p.toString(rouge, neutre, bleue));
				p.coordDispo(rouge, neutre, bleue);
				System.out.print("Veuillez choisir où bouger votre pièce : ");
				String s = sc.next();
				rouge.movePièce(s);
				joueur1.addPoint();
				System.out.println(p.toString(rouge, neutre, bleue));
				p.coordDispo(neutre, rouge, bleue);
				System.out.print("Veuillez choisir où bouger la pièce neutre : ");
				s = sc.next();
				neutre.movePièce(s);
				p.toString();
				++nbTours;
			}
			else {
				System.out.println("Au tour du joueur 2");
				System.out.println(p.toString(rouge, neutre, bleue));
				p.coordDispo(bleue, neutre, rouge);
				System.out.print("Veuillez choisir où bouger votre pièce : ");
				String s = sc.next();
				bleue.movePièce(s);
				joueur2.addPoint();
				System.out.println(p.toString(rouge, neutre, bleue));
				p.coordDispo(neutre, rouge, bleue);
				System.out.print("Veuillez choisir où bouger la pièce neutre : ");
				s = sc.next();
				neutre.movePièce(s);
				p.toString();
				++nbTours;
			}
			System.out.print("Joueur1 : " + joueur1.getPoints());
			System.out.println(" et Joueur 2 : " + joueur2.getPoints());
		}
		sc.close();
	}
}
