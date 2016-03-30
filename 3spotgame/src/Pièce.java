/** Type de donn�e repr�sentant une pi�ce */
public class Pi�ce {
	private String couleur; //Couleur de la pi�ce
	//Coordonn�e repr�sentant la ligne
	private int coordX[][] = new int[Plateau.TAILLE][Plateau.TAILLE];
	//Coordonn�e repr�sentant la colonne
	private int coordY[][] = new int[Plateau.TAILLE][Plateau.TAILLE];
	
	/*Cr�ation d'une pi�ce d'une couleur*/
	public Pi�ce(String couleur) {
		this.couleur = couleur;
		setCoord();
	}
	/**
	 * Donne la couleur de la pi�ce
	 * @return la couleur
	 */
	public String getCouleur() {
		return this.couleur;
	}
	/**
	 * Indique la pr�sence d'une pi�ce
	 * @param i la ligne
	 * @param j la colonne
	 * @return vrai si la pi�ce est pr�sente aux coordonn�es donn�es
	 */
	public boolean pi�cePr�sente(int i, int j) {
		return (this.coordX[i][j] == 1 || this.coordY[i][j] == 1);
	}
	
	/**
	 * Combinaison de deux carr�s pour exprimer la pi�ce sur 
	 * deux carr�s
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
	 * Supprime les coordonn�es
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
	 * D�place la pi�ce
	 * @param p la pi�ce � d�placer
	 */
	public void movePi�ce(String p) {
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
