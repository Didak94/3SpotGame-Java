/** Tyde de donn�e repr�sentant un joueur de 3 Spot Game*/
public class Joueur {
	private int points; // Les points obtenus par le joueur
	private Pi�ce pi�ce; // La pi�ce du joueur
	
	/**
	 * Cr�ation d'un joueur
	 * @param p la pi�ce attribu�e � ce joueur
	 */
	public Joueur(Pi�ce p) {
		this.points = 0; //Points initialis�s � 0 au d�but du jeu
		this.pi�ce = p;
	}
	
	/**
	 * Conna�tre le nombre de points
	 * @return le nombre de points
	 */
	public int getPoints() {
		return this.points;
	}
	/**
	 * 
	 * @return 
	 */
	public Pi�ce getPi�ce() {
		return this.pi�ce;
	}
	/**
	 * 
	 */
	public void addPoint() {
		for (int i = 0; i < Plateau.TAILLE; ++i) {
			if (pi�ce.pi�cePr�sente(i, 2))
				++points;
		}
	}
}
