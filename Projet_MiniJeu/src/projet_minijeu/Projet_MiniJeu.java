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
       int lignes = 5; // Nombre de lignes de la grille
        int colonnes = 5; // Nombre de colonnes de la grille
        int nombreBombes = 5; // Nombre de bombes dans la grille
        int viesInitiales = 3; // Nombre de vies au départ

        // Créer une nouvelle partie
        Partie partie = new Partie(lignes, colonnes, nombreBombes, viesInitiales);

        // Démarrer la partie (inclut la boucle de jeu)
        partie.demarrerPartie();
        
    }
    }
   
        
    

