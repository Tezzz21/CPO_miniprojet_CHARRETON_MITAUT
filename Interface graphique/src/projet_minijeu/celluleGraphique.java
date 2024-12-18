package projet_minijeu;


import java.awt.Graphics;
import projet_minijeu.Cellule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Barnabé
 */
public class celluleGraphique {
    Cellule CelluleAssociee;
    int largeur;
    int longueur;

    public celluleGraphique(Cellule CelluleAssociee, int largeur, int longueur) {
        this.CelluleAssociee = CelluleAssociee;
        this.largeur = largeur;
        this.longueur = longueur;
    }
   
    protected void placerBombesAleatoirement(Graphics g) {
        //super.placerBombesAleatoirement(g);
        //this.setText(CelluleAssociee.toString());
 }

}
