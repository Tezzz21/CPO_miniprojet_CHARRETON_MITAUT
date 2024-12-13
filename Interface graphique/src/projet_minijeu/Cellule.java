package projet_minijeu;

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

    public boolean isDevoilee() {
        return devoilee;
    }
    
    
    
    public void setNbBombesAdjacentes(int nbBombesAdjacentes ){
        if (nbBombesAdjacentes>=0){
            this.nbBombesAdjacentes=nbBombesAdjacentes;
        }
        else {
            nbBombesAdjacentes=-nbBombesAdjacentes;
        }
    }
    @Override
    public String toString() {
        if(devoilee==false){
            return "?";
        }
        if (devoilee==true && presenceBombe==true){
            return "B";
        }
        if (devoilee==true && presenceBombe==false && nbBombesAdjacentes>0){
            return String.valueOf(nbBombesAdjacentes);
        }
        if (devoilee==true && presenceBombe==false && nbBombesAdjacentes==0){
            return " ";
        }
        return null;
    }
}
