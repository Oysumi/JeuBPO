package projetBPO.jeux.oups;

import projetBPO.jeux.EtatAvecEtatFinalCalcule;
import projetBPO.jeux.IEtat;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class Oups extends EtatAvecEtatFinalCalcule {

    private Monde world ;
    private Piece robot ;

    /**
     * Fixe l'état du jeu Oups
     * @param myWorld monde dans lequel on évolue
     * @param salleRobot salle de départ du robot
     */
    public Oups(Monde myWorld, int salleRobot){
        world = new Monde(myWorld) ;
        robot = world.getPiece(salleRobot) ;
    }

    /**
     * Ouvre / fermer une trappe
     * @param noSalle numéro de la salle dans laquelle on ouvre/ferme la trappe
     */
    public void ouvrirTrappe(int noSalle){
        world.ouvrirFermer(noSalle);
    }

    /**
     * @return la description de la salle où se trouve le robot
     */
    public String toString() { return robot.toString(); }

    /**
     * Sert à l'historique
     * @param etat état éventuellement identique
     * @return vrai si les deux états sont égaux
     */
    public boolean equals(Object etat){
        return robot.toString().equals(etat.toString()) ;
    }

    /**
     * Est-ce que le robot est sur une trappe ouverte ?
     * @return vrai si le robot est sur une trappe ouverte
     */
    public boolean estTombe(){
        return robot.trappeOuverte() ;
    }

    /**
     * Itérateur de Oups
     * @return tous les états possibles du robot (nouvelles positions, trappes ouvertes etc...)
     */
    public Iterator<IEtat> iterator(){

        ArrayList<IEtat> nouvellesPieces = new ArrayList<>(100) ; // On imagine un monde très grand
        int nbPassages = robot.nbPassages() ;

        if (!this.estTombe()) {
            for (int i = 0; i < nbPassages; i++) {
                Passage pass = robot.getPassage(i);
                int salle = pass.secondeSalle().getNumero() - 1;
                Oups newWorld = new Oups(world, salle);

                if (pass.activePiege()) {
                    newWorld.ouvrirTrappe(pass.activeTrappe());
                }
                nouvellesPieces.add(newWorld);
            }
        }

        return nouvellesPieces.iterator();
    }

    /**
     * Indique si l'on se trouve sur un trésor
     * @return vrai si l'on se trouve sur un trésor et que l'on est pas tombé
     */
    @Override
    public boolean estUnEtatFinal() {
        return robot.estUnTresor() && !this.estTombe() ;
    }

    /**
     * Getter de pièces
     * @param numero numéro de la pièce à retourner
     * @return la pièce de numéro 'numéro'
     *
     * Ne sera pas utilisé dans le jeu mais est utile aux tests
     */
    public Piece getPiece(int numero){
        return world.getPiece(numero);
    }
}
