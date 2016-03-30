/** Type de donnée représentant une pièce */
public class Pièce {
	private String couleur; //Couleur de la pièce
	//Coordonnée représentant la ligne
	private int coordX[][] = new int[Plateau.TAILLE][Plateau.TAILLE];
	//Coordonnée représentant la colonne
	private int coordY[][] = new int[Plateau.TAILLE][Plateau.TAILLE];
	
	/*Création d'une pièce d'une couleur*/
	public Pièce(String couleur) {
		this.couleur = couleur;
		setCoord();
	}
	/**
	 * Donne la couleur de la pièce
	 * @return la couleur
	 */
	public String getCouleur() {
		return this.couleur;
	}
	/**
	 * Indique la présence d'une pièce
	 * @param i la ligne
	 * @param j la colonne
	 * @return vrai si la pièce est présente aux coordonnées données
	 */
	public boolean piècePrésente(int i, int j) {
		return (this.coordX[i][j] == 1 || this.coordY[i][j] == 1);
	}
	
	/**
	 * Combinaison de deux carrés pour exprimer la pièce sur 
	 * deux carrés
	 */
	private void setCoord() {
		if (this.couleur == "R")
			this.coordX[0][1] = this.coordY[0][2] = 1;
		if (this.couleur == "W")
			this.coordX[1][1] = this.coordY[1][2] = 1;
		if (this.couleur == "B")
			this.coordX[2][1] = this.coordY[2][2] = 1;
	}
	
	/**
	 * 
	 * @param i la ligne
	 * @param j la colonne
	 * @return
	 */
	public boolean getCoordY(int i, int j) {
		return this.coordY[i][j] == 1;
	}
	
	/**
	 * 
	 * @param i la ligne
	 * @param j la colonne
	 * @return
	 */
	public boolean getCoordX(int i, int j) {
		return this.coordX[i][j] == 1;
	}
	/**
	 * Supprime les coordonnées
	 */
	private void resetCoord() {
		for (int i = 0; i < Plateau.TAILLE; ++i) {
			for (int j = 0; j < Plateau.TAILLE; ++j) {
				this.coordX[i][j] = 0;
				this.coordY[i][j] = 0;
			}
		}
	}
	/**
	 * Déplace la pièce
	 * @param p la pièce à déplacer
	 */
	public void movePièce(String p) {
		resetCoord();
		for (int i = 0; i < Plateau.TAILLE; ++i) {
			for (int j = 0; j < Plateau.TAILLE; ++j) {
				if (Plateau.getAireDeJeu(i, j).equals(p)) {
					this.coordX[i][j] = 1;
					Plateau.airePlusDispo(i, j);
					if (Plateau.getAireDispo(i-1, j) == true) {
						if (i-1 != -1) {
							this.coordY[i-1][j] = 1;
							Plateau.airePlusDispo(i-1, j);
						}
					}
					else {
						this.coordY[i][j+1] = 1;
						Plateau.airePlusDispo(i, j+1);
					}
				}
				else {
					if (Plateau.getAireDeJeu(i, j).length() > 1) {
						String min = Character.toString(Plateau.getAireDeJeu(i, j).charAt(0));
						String max = Character.toString(Plateau.getAireDeJeu(i, j).charAt(4));
						if (min.equals(p)) {
							this.coordX[i][j] = 1;
							this.coordY[i-1][j] = 1;
							Plateau.airePlusDispo(i, j);
							Plateau.airePlusDispo(i-1, j);
						}
						else if (max.equals(p)) {
							this.coordX[i][j] = 1;
							this.coordY[i][j+1] = 1;
							Plateau.airePlusDispo(i, j);
							Plateau.airePlusDispo(i, j+1);
						}
					}
				}
			}
		}
	}
}
