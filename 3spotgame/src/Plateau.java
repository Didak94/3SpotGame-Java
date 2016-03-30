/** Type de donn�e repr�sentant un plateau de jeu de 3 Spot Game */
public class Plateau {
	 // La taille du plateau exprim�e en constante
	public final static int TAILLE = 3;
	private static int NbD�plDispo; // Nombre de d�placements disponibles
									// pendant le jeu
	// Aire de jeu du plateau avec 3 lignes et 3 colonnes contenant des cha�nes
	// de caract�res
	private static String[][] aireDeJeu = new String[TAILLE][TAILLE];
	// Les carr�s du plateau qui sont disponibles
	private static boolean[][] aireDispo = new boolean[TAILLE][TAILLE];

	/* Cr�ation du plateau de jeu */
	public Plateau() {
		Pi�ce rouge = new Pi�ce("R"); // Cr�ation de la pi�ce rouge
		Pi�ce bleue = new Pi�ce("B"); // Cr�ation de la pi�ce bleue
		Pi�ce neutre = new Pi�ce("W"); // Cr�ation de la pi�ce neutre
		NbD�plDispo = 0; // Nombre des d�placements disponibles � 0

		/* Initialisation de l'�tat des carr�es du plateau de jeu */
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
	 * Indique si la partie est termin�e
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 * @return vrai si la partie est termin�e 
	 */
	public boolean partieTermin�e(Joueur joueur1, Joueur joueur2) {
		if ((joueur1.getPoints() == 12 && joueur2.getPoints() >= 6)
				|| (joueur2.getPoints() == 12 && joueur1.getPoints() >= 6)) {
			System.out.println("Victoire pour le joueur "
					+ (joueur1.getPoints() == 12 ? "1. " : "2. ")
					+ "F�licitation");
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
	 * Donne les coordonn�es des carr�s du plateau
	 * @param i la ligne
	 * @param j la colonne
	 * @return les coordonn�es i et j du carr�
	 */
	public static String getAireDeJeu(int i, int j) {
		return aireDeJeu[i][j];
	}

	/**
	 * Indique l'espace o� l'on peut d�placer les pi�ces
	 * @param i
	 * @param j
	 * @return les coordonn�es i et j des carr�s disponibles dans le jeu
	 */
	public static boolean getAireDispo(int i, int j) {
		if (i == -1)
			return false;
		else
			return aireDispo[i][j];
	}
	/**
	 * Affiche l'�tat initiale du plateau avant le d�but du jeu
	 * @param pi�ce1 la premi�re pi�ce
	 * @param pi�ce2 la seconde pi�ce
	 * @param pi�ce3 la troisi�me pi�ce
	 * @return le plateau
	 */
	public String toString(Pi�ce pi�ce1, Pi�ce pi�ce2, Pi�ce pi�ce3) {
		String affiche = new String();
		for (int i = 0; i < TAILLE; ++i) {
			affiche += "* * * * * * * * * * * * *\n";
			affiche += "*       *       *       *\n";
			affiche += "*   " + affichage(i, 0, pi�ce1, pi�ce2, pi�ce3);
			affiche += "   *   " + affichage(i, 1, pi�ce1, pi�ce2, pi�ce3);
			affiche += "   *   " + affichage(i, 2, pi�ce1, pi�ce2, pi�ce3);
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
	 * @param pi�ce1
	 * @param pi�ce2
	 * @param pi�ce3
	 * @return
	 */
	private String affichage(int i, int j, Pi�ce pi�ce1, Pi�ce pi�ce2,
			Pi�ce pi�ce3) {
		if (!aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "\0";
		if (pi�ce1.pi�cePr�sente(i, j))
			aireDeJeu[i][j] = pi�ce1.getCouleur();
		if (pi�ce2.pi�cePr�sente(i, j))
			aireDeJeu[i][j] = pi�ce2.getCouleur();
		if (pi�ce3.pi�cePr�sente(i, j))
			aireDeJeu[i][j] = pi�ce3.getCouleur();
		if (j == 2 && aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "O";
		return aireDeJeu[i][j];
	}
	/**
	 * 
	 * @param pi�ceJouer
	 * @param hold1
	 * @param hold2
	 * @return
	 */
	private String toString2(Pi�ce pi�ceJouer, Pi�ce hold1, Pi�ce hold2) {
		String affiche = new String();
		for (int i = 0; i < TAILLE; ++i) {
			affiche += "* * * * * * * * * * * * *\n";
			affiche += "*       *       *       *\n";
			if (aireDeJeu[i][0].length() > 1)
				affiche += "*" + affichage2(i, 0, pi�ceJouer, hold1, hold2);
			else
				affiche += "*   " + affichage2(i, 0, pi�ceJouer, hold1, hold2);
			if (aireDeJeu[i][1].length() > 1)
				affiche += "   *" + affichage2(i, 1, pi�ceJouer, hold1, hold2);
			else
				affiche += "   *   "
						+ affichage2(i, 1, pi�ceJouer, hold1, hold2);
			if (aireDeJeu[i][2].length() > 1)
				affiche += "   *" + affichage2(i, 2, pi�ceJouer, hold1, hold2);
			else
				affiche += "   *   "
						+ affichage2(i, 2, pi�ceJouer, hold1, hold2);
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
	 * @param pi�ceJouer
	 * @param hold1
	 * @param hold2
	 * @return
	 */
	private String affichage2(int i, int j, Pi�ce pi�ceJouer, Pi�ce hold1,
			Pi�ce hold2) {
		if (aireDeJeu[i][j].equals(pi�ceJouer.getCouleur()))
			aireDeJeu[i][j] = "\0";
		if (hold1.pi�cePr�sente(i, j))
			aireDeJeu[i][j] = hold1.getCouleur();
		if (hold2.pi�cePr�sente(i, j))
			aireDeJeu[i][j] = hold2.getCouleur();
		if (j == 2 && aireDeJeu[i][j].equals("\0"))
			aireDeJeu[i][j] = "O";
		return aireDeJeu[i][j];
	}
	/**
	 * 
	 * @param pi�ceJouer
	 * @param hold1
	 * @param hold2
	 * @param i la ligne
	 * @param j la colonne
	 * @param t
	 * @param s
	 */
	private void rechercheDisponibilit�s(Pi�ce pi�ceJouer, Pi�ce hold1,
			Pi�ce hold2, int i, int j, int t[][], String s) {
		if (i - 1 >= 0) {
			if (!hold1.pi�cePr�sente(i - 1, j) && t[i - 1][j] != 1) {
				if (!hold2.pi�cePr�sente(i - 1, j) && t[i - 1][j] != 1) {
					s = addPossDepl(s, i, j);
					aireDeJeu[i][j] = s;
					t[i - 1][j] = 1;
					rechercheDisponibilit�s(pi�ceJouer, hold1, hold2, i, j, t,
							s);
				}
			}
		}
		if (j + 1 < TAILLE) {
			if (!hold1.pi�cePr�sente(i, j + 1) && j + 1 < TAILLE
					&& t[i][j + 1] != 1) {
				if (!hold2.pi�cePr�sente(i, j + 1) && j + 1 < TAILLE
						&& t[i][j + 1] != 1) {
					s = addPossDepl(s, i, j);
					aireDeJeu[i][j] = s;
					t[i][j + 1] = 1;
					rechercheDisponibilit�s(pi�ceJouer, hold1, hold2, i, j, t,
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
			++NbD�plDispo;
			s = s + " - " + String.valueOf(NbD�plDispo);
			return s;
		} else {
			++NbD�plDispo;
			s = String.valueOf(NbD�plDispo);
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
	 * @param pi�ceJouer
	 * @param hold1
	 * @param hold2
	 */
	public void coordDispo(Pi�ce pi�ceJouer, Pi�ce hold1, Pi�ce hold2) {
		int t[][] = new int[TAILLE][TAILLE];
		String s = new String();
		s = String.valueOf(NbD�plDispo);
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				if (pi�ceJouer.getCoordY(i, j) == true)
					aireDispo[i][j] = true;
				if (getAireDispo(i, j) == true) {
					rechercheDisponibilit�s(pi�ceJouer, hold1, hold2, i, j, t,
							s);
					Clear(t);
				}
			}
		}
		for (int i = 0; i < TAILLE; ++i) {
			for (int j = 0; j < TAILLE; ++j) {
				if (pi�ceJouer.getCoordX(i, j) == true)
					aireDispo[i][j] = true;
			}
		}
		System.out.println(toString2(pi�ceJouer, hold1, hold2));
		NbD�plDispo = 0;
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
