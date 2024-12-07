/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_minijeu;

/**
 *
 * @author tessc
 */
public class Partie {
    private GrilleDeJeu grille;
    private int nbVies;
    private boolean enCours;
    
    // Constructeur
    public Partie(int nbLignes, int nbColonnes, int nbBombes, int nbVies) {
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes,nbBombes);
        this.nbVies = nbVies;
        this.enCours = true;
    }
    private void initialiserPartie() {
        grille.placerBombesAleatoirement();
        this.nbVies = nbVies;           
        this.enCours = true;
        }
    
    public void tourDeJeu(int ligne, int colonne){
        if (!enCours) {
            System.out.println("La partie est terminée.");
            return;
        }
        grille.revelerCellule(ligne, colonne);
        
    }
}
