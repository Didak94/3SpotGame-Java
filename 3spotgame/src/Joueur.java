/** Tyde de donnée représentant un joueur de 3 Spot Game*/
public class Joueur {
	private int points; // Les points obtenus par le joueur
	private Pièce pièce; // La pièce du joueur
	
	/**
	 * Création d'un joueur
	 * @param p la pièce attribuée à ce joueur
	 */
	public Joueur(Pièce p) {
		this.points = 0; //Points initialisés à 0 au début du jeu
		this.pièce = p;
	}
	
	/**
	 * Connaître le nombre de points
	 * @return le nombre de points
	 */
	public int getPoints() {
		return this.points;
	}
	/**
	 * 
	 * @return 
	 */
	public Pièce getPièce() {
		return this.pièce;
	}
	/**
	 * 
	 */
	public void addPoint() {
		for (int i = 0; i < Plateau.TAILLE; ++i) {
			if (pièce.piècePrésente(i, 2))
				++points;
		}
	}
}
