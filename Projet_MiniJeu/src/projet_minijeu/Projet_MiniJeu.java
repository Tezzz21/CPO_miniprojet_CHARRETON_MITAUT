/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_minijeu;

/**
 *
 * @author tessc
 */
public class Projet_MiniJeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GrilleDeJeu grille = new GrilleDeJeu(10, 10, 10);
       grille.placerBombesAleatoirement();
       grille.calculerBombesAdjacentes();
        // Afficher la grille initiale
        System.out.println("Grille initiale :");
        System.out.println(grille);

        // Révéler une cellule
        grille.revelerCellule(1, 0);

        // Afficher la grille après révélation
        System.out.println("Grille apres avoir revelee (0, 0) :");
        System.out.println(grille);
    }
   
        
    
}
