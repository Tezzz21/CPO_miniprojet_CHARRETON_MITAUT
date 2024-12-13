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
    private int vies;
    private boolean partieTerminee;
    
    // Constructeur
    public Partie(int lignes, int colonnes, int nombreBombes, int viesInitiales) {
        this.grille = new GrilleDeJeu(lignes, colonnes, nombreBombes);
        this.vies = viesInitiales;
        this.partieTerminee = false;
    }
    public void initialiserPartie() {
        grille.placerBombesAleatoirement(); // Place les bombes aléatoirement sur la grille
        grille.calculerBombesAdjacentes(); // Calcule le nombre de bombes adjacentes pour chaque cellule
        this.vies = 3; // Réinitialisation des vies (ou autre valeur par défaut)
        this.partieTerminee = false;
        System.out.println("Nouvelle partie démarrée !");
    }
    
    public void tourDeJeu(int ligne, int colonne) {
        
        if (partieTerminee) {
            System.out.println("La partie est terminée. Veuillez démarrer une nouvelle partie.");
            return;
        }

        boolean bombeTrouvee = grille.getPresenceBombe(ligne, colonne);
        if (bombeTrouvee) {
            vies--;
            System.out.println("Boom ! Une bombe a explosé. Vies restantes : " + vies);
            if (vies <= 0) {
                partieTerminee = true;
                System.out.println("Game Over !");
            }
        } else {
            grille.calculerBombesAdjacentes();
            grille.revelerCellule(ligne, colonne);
            System.out.println(grille);
        }

        if (verifierVictoire()) {
            partieTerminee = true;
            System.out.println("Félicitations ! Vous avez gagné !");
        }
    }
    public boolean verifierVictoire() {
        return grille.toutesCellulesRevelees();
    }
    public void demarrerPartie() {
        initialiserPartie();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (!partieTerminee) {
            System.out.println("Entrez les coordonnées de la cellule à révéler (ligne colonne) : ");
            int ligne = scanner.nextInt();
            int colonne = scanner.nextInt();
            tourDeJeu(ligne, colonne);
        }
        scanner.close();
    }
}
