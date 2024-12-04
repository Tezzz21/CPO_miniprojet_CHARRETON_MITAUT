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
      public void calculerBombesAdjacentes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].getPresenceBombe()) {
                    int nbBombesAdjacentes = compterBombesAdjacentes(i, j);
                    matriceCellules[i][j].setNbBombesAdjacentes(nbBombesAdjacentes);
                }
            }
        }
    }

    private int compterBombesAdjacentes(int x, int y) {
        int bombes = 0;

        // Parcourir les 8 directions autour de la cellule
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignorer la cellule centrale
                int voisinX = x + i;
                int voisinY = y + j;

                // Vérifier si le voisin est dans les limites de la grille
                if (voisinX >= 0 && voisinX < nbLignes && voisinY >= 0 && voisinY < nbColonnes) {
                    if (matriceCellules[voisinX][voisinY].getPresenceBombe()) {
                        bombes++;
                    }
                }
            }
        }

        return bombes;
    }
    public void revelerCellule(int ligne, int colonne) {
        // Vérifier si la cellule est déjà dévoilée
        if (matriceCellules[ligne][colonne].isDevoilee()==true) {
            return;
        }
        
            
        // Révéler la cellule
        matriceCellules[ligne][colonne].revelerCellule();

        

        // Si la cellule ne contient pas de bombes adjacentes, propager la révélation
        if (matriceCellules[ligne][colonne].getNbBombesAdjacentes() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int voisinX = ligne + i;
                    int voisinY = colonne + j;

                    // Vérifier les limites et éviter de révéler la cellule elle-même
                    if ((i != 0 || j != 0) && voisinX >= 0 && voisinX < nbLignes && voisinY >= 0 && voisinY < nbColonnes) {
                        revelerCellule(voisinX, voisinY);
                    }
                }
            }
        }
    }
    public boolean getPresenceBombe(int i, int j) {
        return matriceCellules[i][j].getPresenceBombe();
    }
     public boolean toutesCellulesRevelees() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                Cellule cellule = matriceCellules[i][j];
                if (!cellule.getPresenceBombe() && !cellule.isDevoilee()) {
                    return false;
                }
            }
        }
        return true;
    }
      @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Ajouter les indices de colonnes
        sb.append("   "); // Alignement
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(j).append(" ");
        }
        sb.append("\n");

        // Ajouter la grille ligne par ligne
        for (int i = 0; i < nbLignes; i++) {
            sb.append(i).append(" |"); // Ajouter l'indice de la ligne
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j]).append(" ");
                
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}


