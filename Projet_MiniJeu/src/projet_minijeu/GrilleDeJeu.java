package projet_minijeu;

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
        // Constructeur : on initialise une grille
    public GrilleDeJeu(int lignes, int colonnes) {
        if (lignes <= 0 || colonnes <= 0) {
            throw new IllegalArgumentException("Les dimensions de la grille doivent être positives.");
        }
        matriceCellules = new Cellule[lignes][colonnes];
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                matriceCellules[i][j] = new Cellule(); // Initialisation des cellules
            }
        }
    }
    
}
