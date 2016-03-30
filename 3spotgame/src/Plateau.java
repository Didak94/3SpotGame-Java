/** Type de donnée représentant un plateau de jeu de 3 Spot Game */
public class Plateau {
	 // La taille du plateau exprimée en constante
	public final static int TAILLE = 3;
	private static int NbDéplDispo; // Nombre de déplacements disponibles
									// pendant le jeu
	// Aire de jeu du plateau avec 3 lignes et 3 colonnes contenant des chaînes
	// de caractères
	private static String[][] aireDeJeu = new String[TAILLE][TAILLE];
	// Les carrés du plateau qui sont disponibles
	private static boolean[][] aireDispo = new boolean[TAILLE][TAILLE];

	/* Création du plateau de jeu */
	public Plateau() {
		Pièce rouge = new Pièce("R"); // Création de la pièce rouge
		Pièce bleue = new Pièce("B"); // Création de la pièce bleue
		Pièce neutre = new Pièce("W"); // Création de la pièce neutre
		NbDéplDispo = 0; // Nombre des déplacements disponibles à 0

		/* Initialisation de l'état des carrées du plateau de jeu */
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				if (i == 0 && j > 0) {
					aireDeJeu[i][j] = rouge.getCouleur();
					aireDispo[i][j] = false;
				} else if (i == 1 && j > 0) {
					aireDeJeu[i][j] = neutre.getCouleur();
					aireDispo[i][j] = false;
				} else if (i == 2 && j > 0) {
					aireDeJeu[i][j] = bleue.getCouleur();
					aireDispo[i][j] = false;
				} else {
					aireDeJeu[i][j] = "\0";
					aireDispo[i][j] = true;
				}
			}
		}
	}
	
	/**
	 * Indique si la partie est terminée
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 * @return vrai si la partie est terminée 
	 */
	public boolean partieTerminée(Joueur joueur1, Joueur joueur2) {
		if ((joueur1.getPoints() == 12 && joueur2.getPoints() >= 6)
				|| (joueur2.getPoints() == 12 && joueur1.getPoints() >= 6)) {
			System.out.println("Victoire pour le joueur "
					+ (joueur1.getPoints() == 12 ? "1. " : "2. ")
					+ "Félicitation");
			return true;
		}
		if ((joueur1.getPoints() == 12 && joueur2.getPoints() < 6)
				|| (joueur2.getPoints() == 12 && joueur1.getPoints() < 6)) {
			System.out.println("Sorry joueur "
							+ (joueur1.getPoints() == 12 ? "1, " : "2, ")
							+ " you lost");
			return true;
		} else
			return false;
	}
	/**
	 * Donne les coordonnées des carrés du plateau
	 * @param i la ligne
	 * @param j la colonne
	 * @return les coordonnées i et j du carré
	 */
	public static String getAireDeJeu(int i, int j) {
		return aireDeJeu[i][j];
	}

	/**
	 * Indique l'espace où l'on peut déplacer les pièces
	 * @param i
	 * @param j
	 * @return les coordonnées i et j des carrés disponibles dans le jeu
	 */
	public static boolean getAireDispo(int i, int j) {
		if (i == -1)
			return false;
		else
			return aireDispo[i][j];
	}
	/**
	 * Affiche l'état initiale du plateau avant le début du jeu
	 * @param pièce1 la première pièce
	 * @param pièce2 la seconde pièce
	 * @param pièce3 la troisième pièce
	 * @return le plateau
	 */
	public String toString(Pièce pièce1, Pièce pièce2, Pièce pièce3) {
		String affiche = new String();
		for (int i = 0; i < TAILLE; ++i) {
			affiche += "* * * * * * * * * * * * *\n";
			affiche += "*       *       *       *\n";
			affiche += "*   " + affichage(i, 0, pièce1, pièce2, pièce3);
			affiche += "   *   " + affichage(i, 1, pièce1, pièce2, pièce3);
			affiche += "   *   " + affichage(i, 2, pièce1, pièce2, pièce3);
			affiche += "   *\n";
			affiche += "*       *       *       *\n";
		}
		affiche += "* * * * * * * * * * * * *\n";
		return affiche;
	}
	/**
	 * 
	 * @param i la ligne
	 * @param j la colonne
	 * @param pièce1
	 * @param pièce2
	 * @param pièce3
	 * @return
	 */
	private String affichage(int i, int j, Pièce pièce1, Pièce pièce2,
			Pièce pièce3) {
		if (!aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "\0";
		if (pièce1.piècePrésente(i, j))
			aireDeJeu[i][j] = pièce1.getCouleur();
		if (pièce2.piècePrésente(i, j))
			aireDeJeu[i][j] = pièce2.getCouleur();
		if (pièce3.piècePrésente(i, j))
			aireDeJeu[i][j] = pièce3.getCouleur();
		if (j == 2 && aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "O";
		return aireDeJeu[i][j];
	}
	/**
	 * 
	 * @param pièceJouer
	 * @param hold1
	 * @param hold2
	 * @return
	 */
	private String toString2(Pièce pièceJouer, Pièce hold1, Pièce hold2) {
		String affiche = new String();
		for (int i = 0; i < TAILLE; ++i) {
			affiche += "* * * * * * * * * * * * *\n";
			affiche += "*       *       *       *\n";
			if (aireDeJeu[i][0].length() > 1)
				affiche += "*" + affichage2(i, 0, pièceJouer, hold1, hold2);
			else
				affiche += "*   " + affichage2(i, 0, pièceJouer, hold1, hold2);
			if (aireDeJeu[i][1].length() > 1)
				affiche += "   *" + affichage2(i, 1, pièceJouer, hold1, hold2);
			else
				affiche += "   *   "
						+ affichage2(i, 1, pièceJouer, hold1, hold2);
			if (aireDeJeu[i][2].length() > 1)
				affiche += "   *" + affichage2(i, 2, pièceJouer, hold1, hold2);
			else
				affiche += "   *   "
						+ affichage2(i, 2, pièceJouer, hold1, hold2);
			affiche += "   *\n";
			affiche += "*       *       *       *\n";
		}
		affiche += "* * * * * * * * * * * * *\n";
		return affiche;
	}
	/**
	 * 
	 * @param i la ligne
	 * @param j la colonne
	 * @param pièceJouer
	 * @param hold1
	 * @param hold2
	 * @return
	 */
	private String affichage2(int i, int j, Pièce pièceJouer, Pièce hold1,
			Pièce hold2) {
		if (aireDeJeu[i][j].equals(pièceJouer.getCouleur()))
			aireDeJeu[i][j] = "\0";
		if (hold1.piècePrésente(i, j))
			aireDeJeu[i][j] = hold1.getCouleur();
		if (hold2.piècePrésente(i, j))
			aireDeJeu[i][j] = hold2.getCouleur();
		if (j == 2 && aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "O";
		return aireDeJeu[i][j];
	}
	/**
	 * 
	 * @param pièceJouer
	 * @param hold1
	 * @param hold2
	 * @param i la ligne
	 * @param j la colonne
	 * @param t
	 * @param s
	 */
	private void rechercheDisponibilités(Pièce pièceJouer, Pièce hold1,
			Pièce hold2, int i, int j, int t[][], String s) {
		if (i - 1 >= 0) {
			if (!hold1.piècePrésente(i - 1, j) && t[i - 1][j] != 1) {
				if (!hold2.piècePrésente(i - 1, j) && t[i - 1][j] != 1) {
					s = addPossDepl(s, i, j);
					aireDeJeu[i][j] = s;
					t[i - 1][j] = 1;
					rechercheDisponibilités(pièceJouer, hold1, hold2, i, j, t,
							s);
				}
			}
		}
		if (j + 1 < TAILLE) {
			if (!hold1.piècePrésente(i, j + 1) && j + 1 < TAILLE
					&& t[i][j + 1] != 1) {
				if (!hold2.piècePrésente(i, j + 1) && j + 1 < TAILLE
						&& t[i][j + 1] != 1) {
					s = addPossDepl(s, i, j);
					aireDeJeu[i][j] = s;
					t[i][j + 1] = 1;
					rechercheDisponibilités(pièceJouer, hold1, hold2, i, j, t,
							s);
				}
			}
		}
	}
	/**
	 * 
	 * @param s
	 * @param i la ligne
	 * @param j la colonne
	 * @return
	 */
	private String addPossDepl(String s, int i, int j) {
		if (aireDeJeu[i][j].equals(s)) {
			++NbDéplDispo;
			s = s + " - " + String.valueOf(NbDéplDispo);
			return s;
		} else {
			++NbDéplDispo;
			s = String.valueOf(NbDéplDispo);
			return s;
		}
	}
	/**
	 * 
	 * @param t
	 */
	private void Clear(int t[][]) {
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				t[i][j] = 0;
			}
		}
	}
	/**
	 * 
	 * @param pièceJouer
	 * @param hold1
	 * @param hold2
	 */
	public void coordDispo(Pièce pièceJouer, Pièce hold1, Pièce hold2) {
		int t[][] = new int[TAILLE][TAILLE];
		String s = new String();
		s = String.valueOf(NbDéplDispo);
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				if (pièceJouer.getCoordY(i, j) == true)
					aireDispo[i][j] = true;
				if (getAireDispo(i, j) == true) {
					rechercheDisponibilités(pièceJouer, hold1, hold2, i, j, t,
							s);
					Clear(t);
				}
			}
		}
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				if (pièceJouer.getCoordX(i, j) == true)
					aireDispo[i][j] = true;
			}
		}
		System.out.println(toString2(pièceJouer, hold1, hold2));
		NbDéplDispo = 0;
	}
	/**
	 * 
	 * @param i la ligne
	 * @param j la colonne
	 */
	public static void airePlusDispo(int i, int j) {
		aireDispo[i][j] = false;
	}

}
