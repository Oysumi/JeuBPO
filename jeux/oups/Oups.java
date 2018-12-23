package projetBPO.jeux.oups;

import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.IEtat;

import java.util.ArrayList;
import java.util.Iterator;

public class Oups extends EtatAvecEtatFinalPredefini {

    private Monde world ;
    private Piece robot ;

    public Oups(Monde myWorld, Piece salleRobot){
        world = myWorld ;
        robot = salleRobot ;
    }

    public void ouvrirTrappe(int noSalle){
        world.ouvrirFermer(noSalle);
    }

    public String toString() { return robot.toString(); }

    public boolean equals(Object etat){
        return robot.toString().equals(etat.toString()) ;
    }

    public boolean estTombe(){
        return robot.trappeOuverte() ;
    }

    public Iterator<IEtat> iterator(){

        ArrayList<IEtat> nouvellesPieces = new ArrayList<>(100) ; // On imagine un monde très grand
        int nbPassages = robot.nbPassages() ;

        for (int i = 1 ; i <= nbPassages ; i++){
            Passage pass = robot.getPassage(i);
            Piece salle = pass.secondeSalle();
            Oups newWorld = new Oups(world, salle);
            if (pass.activePiege()){
                newWorld.ouvrirTrappe(pass.activeTrappe());
            }
            if (!newWorld.estTombe()){
                nouvellesPieces.add(newWorld);
            }
        }

        return nouvellesPieces.iterator();
    }

    /* Ne sera pas utilisé dans le jeu mais est utile aux tests */
    public Piece getPiece(int numero){
        return world.getPiece(numero);
    }
}
