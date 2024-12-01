package projet_minijeu;
import java.util.Random;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tessc
 */
public class GrilleDeJeu {
    private Cellule[][] matriceCellules;
    private int nbLignes;    
    private int nbColonnes; 
    private int nbBombes; 
    
    public int getNbLignes() {
        return nbLignes;
    }
    public int getNbColonnes() {
        return nbColonnes;
    }
    public int getNbBombes() {
        return nbBombes;
    }
    
        // Constructeur : on initialise une grille
    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matriceCellules = new Cellule[nbLignes][nbColonnes];

        // Initialiser toutes les cellules
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new Cellule();
            }
        }
    }
    // Méthode pour placer les bombes aléatoirement
    public void placerBombesAleatoirement() {
        Random random = new Random();
        int bombesPlacees = 0;

        while (bombesPlacees < nbBombes) {
            // Générer des coordonnées aléatoires
            int i = random.nextInt(nbLignes);
            int j = random.nextInt(nbColonnes);

            // Vérifier si la cellule ne contient pas déjà une bombe
            if (matriceCellules[i][j].getPresenceBombe()== false) {
                matriceCellules[i][j].placerBombe(); // Placer une bombe
                bombesPlacees++; // Incrementer le compteur de bombes placées
            }
        }
    }
     private int compterBombesAdjacentes(int ligne, int colonne) {
        int count = 0;

        // Parcourir les 8 directions autour de la cellule (ligne, colonne)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Ignorer la cellule centrale
                }

                int adjLigne = ligne + i;
                int adjColonne = colonne + j;

                // Vérifier si les coordonnées adjacentes sont dans les limites de la grille
                if (adjLigne >= 0 && adjLigne < nbLignes && adjColonne >= 0 && adjColonne < nbColonnes) {
                    if (matriceCellules[adjLigne][adjColonne].getPresenceBombe()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
