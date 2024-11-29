/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tessc
 */
public class Cellule {
    private boolean presenceBombe;
    private boolean devoilee;
    int nbBombesAdjacentes;
    
    public boolean getPresenceBombe(){
        return presenceBombe;
    }
    public int getNbBombesAdjacentes(){
        return nbBombesAdjacentes;
    }
    public void placerBombe() {
        this.presenceBombe = true; // Place une bombe dans la cellule
    }
    public void revelerCellule() {
        this.devoilee = true; // Révèle la cellule
    }
}
