/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_minijeu;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tessc
 */
public class Partie {
    private GrilleDeJeu grille;
    private int vies;
    private boolean partieTerminee;
    private JPanel PanneauGrille;
    public int lignes;
    public int colonnes;
    public fenetre_principale Fenetre_Jeu;

    
    // Constructeur
    public Partie(int lignes, int colonnes, int nombreBombes, int viesInitiales, GrilleDeJeu grille, JPanel PanneauGrille, fenetre_principale JEU ) {
        this.vies = viesInitiales;
        this.partieTerminee = false;
        this.PanneauGrille = PanneauGrille;
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.Fenetre_Jeu =JEU;
        
        // Initialisation de la grille de jeu
        this.grille = new GrilleDeJeu(lignes, colonnes, nombreBombes, PanneauGrille);

        // Définir le layout du panneau comme une grille
        PanneauGrille.setLayout(new GridLayout(lignes, colonnes));

        // Boucles pour créer les boutons correspondant aux cellules graphiques
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {

                // Créer une cellule graphique
                celluleGraphique bouton_cellule = new celluleGraphique(
                    this.grille.getCelluleFromMatriceCellules(i, j),
                    36, 36
                );

                // Associer les coordonées de chaque cellule pour les retrouver dans le tour de jeu
                this.grille.getCelluleFromMatriceCellules(i, j).setPosi(i);
                this.grille.getCelluleFromMatriceCellules(i, j).setPosj(j);

                // Créer un bouton pour représenter visuellement la cellule
                JButton bouton = new JButton("?"); // Texte initial du bouton
                bouton.setPreferredSize(new Dimension(36, 36)); // Taille des boutons

                // Ajouter un ActionListener pour gérer les clics
                bouton.addActionListener(e -> {
                    // Révéler la cellule associée à ce bouton
                    //bouton_cellule.CelluleAssociee.revelerCellule();

                    this.grille.revelerCellule(bouton_cellule.CelluleAssociee.getPosi(), bouton_cellule.CelluleAssociee.getPosj());

                    // Mettre à jour le texte du bouton selon l'état de la cellule
                    bouton.setText(bouton_cellule.CelluleAssociee.toString());
                    bouton.setEnabled(false); // Désactiver le bouton après clic
                    
                    tourDeJeu( bouton_cellule.CelluleAssociee.getPosi(),bouton_cellule.CelluleAssociee.getPosj());


                });

                // Ajouter le bouton au panneau
                PanneauGrille.add(bouton);
            }
        }
    }
    public void initialiserPartie() {
        this.grille.placerBombesAleatoirement(); // Place les bombes aléatoirement sur la grille
        this.grille.calculerBombesAdjacentes(); // Calcule le nombre de bombes adjacentes pour chaque cellule
        this.partieTerminee = false;
    }
    
    public void tourDeJeu(int ligne, int colonne) {
        
        if (partieTerminee) {
            //System.out.println("La partie est terminée. Veuillez démarrer une nouvelle partie.");
            fenetre_perdu Perdu = new fenetre_perdu();
            Perdu.setVisible(true);
            this.Fenetre_Jeu.dispose();

            return;
        }

        boolean bombeTrouvee = grille.getPresenceBombe(ligne, colonne);
        if (bombeTrouvee) {
            vies--;
            System.out.println("Boom ! Une bombe a explosé. Vies restantes : " + vies);
            if (vies <= 0) {
                partieTerminee = true;
                System.out.println("Game Over !");
                fenetre_perdu Perdu = new fenetre_perdu();
                Perdu.setVisible(true);
                this.Fenetre_Jeu.dispose();



            }
        } else {
            grille.calculerBombesAdjacentes();
            //grille.revelerCellule(ligne, colonne);
            System.out.println(grille);
        }

        if (verifierVictoire()) {
            partieTerminee = true;
            System.out.println("Félicitations ! Vous avez gagné !");
            fenetre_gagne gagne = new fenetre_gagne();
            gagne.setVisible(true);
            this.Fenetre_Jeu.dispose();
        }
    }
    public boolean verifierVictoire() {
        return grille.toutesCellulesRevelees();
    }
    public void demarrerPartie() {
        initialiserPartie();
        //java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (!partieTerminee) {
            /*System.out.println("Entrez les coordonnées de la cellule à révéler (ligne colonne) : ");
            int ligne = scanner.nextInt();
            int colonne = scanner.nextInt();
            */
            //tourDeJeu(ligne, colonne);
        }
        //scanner.close();
    }
}
