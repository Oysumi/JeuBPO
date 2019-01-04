package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.IEtat;
import projetBPO.jeux.oups.Monde;
import projetBPO.jeux.oups.Oups;
import projetBPO.jeux.oups.Passage;
import projetBPO.jeux.oups.Piece;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OupsTest {

    private Oups etatDepart ;
    private Monde world ;

    @BeforeEach
    void setUp(){
        /*        ______ ______ ______
                 |      |      |      |
                 |  1R <->  2  |  3P  |      a)   1 <-> 2  active/désactive trappe en 6
                 |__  __|__  __|__  __|      b)   5 <-> 6  active/désactive trappe en 7
                 |      |      |      |
                 |   4  |  5P <-> 6*  |      Legende :
                 |___  _|______|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7*    8T R'|   9  |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ
                                                        - R' = Robot à la fin

         */

        // Déclaration du monde
        world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(5,0,1);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world, 0);
    }

    @Test
    void instanciation() {
        if (!etatDepart.toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le robot n'est pas dans la bonne pièce.");
        }

        Piece res = etatDepart.getPiece(0);
        Passage pass ;

        /*******************************************************************************************/

        if (!res.toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 2){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des piège).");
        }
        if (!res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils n'activent pas des pièges).");
        }
        if (res.getPassage(1).activeTrappe() != 5){
            fail("Le jeu ne contient pas les bons passages (ils n'activent pas les bons pièges.");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(1);

        if (!res.toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 2){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        if (!res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils n'activent pas des pièges).");
        }
        if (res.getPassage(1).activeTrappe() != 5){
            fail("Le jeu ne contient pas les bons passages (ils activent de mauvais pièges.)");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(2);
        if (!res.toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 1){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges.");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(3);
        if (!res.toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 2){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges.");
        }
        if (res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(4);
        if (!res.toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 2){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges.");
        }
        if (!res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils n'activent pas de piège).");
        }
        if (res.getPassage(1).activeTrappe() != 6){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(5);
        if (!res.toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 3){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges.");
        }
        if (res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activenT des pièges).");
        }
        if (!res.getPassage(2).activePiege()){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(2).activeTrappe() != 6){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 9 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(2);
        if (!pass.premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(6);
        if (!res.toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 2){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        if (res.getPassage(1).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        pass = res.getPassage(1);
        if (!pass.premiereSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 8 | Trésor : true | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(7);
        if (!res.toString().equals("Numéro : 8 | Trésor : true | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 1){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 8 | Trésor : true | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }

        /*******************************************************************************************/

        res = etatDepart.getPiece(8);
        if (!res.toString().equals("Numéro : 9 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas le bon monde (pièces).");
        }
        if (res.nbPassages() != 1){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le jeu ne contient pas les bons passages (ils activent des pièges).");
        }
        pass = res.getPassage(0);
        if (!pass.premiereSalle().toString().equals("Numéro : 9 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
        if (!pass.secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu ne contient pas les bons passages.");
        }
    }

    @Test
    void ouvrirTrappe() {
        /* On suppose que le test d'instanciation s'est bien passé */
        etatDepart.ouvrirTrappe(0);
        etatDepart.ouvrirTrappe(8);
        etatDepart.ouvrirTrappe(2);

        Piece salle = etatDepart.getPiece(0);
        if (!salle.toString().equals("Numéro : 1 | Trésor : false | Trappe : true")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(1);
        if (!salle.toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(2);
        if (!salle.toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            System.out.println(salle);
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(3);
        if (!salle.toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(4);
        if (!salle.toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(5);
        if (!salle.toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(6);
        if (!salle.toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(7);
        if (!salle.toString().equals("Numéro : 8 | Trésor : true | Trappe : false")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/

        salle = etatDepart.getPiece(8);
        if (!salle.toString().equals("Numéro : 9 | Trésor : false | Trappe : true")){
            fail("Le jeu n'ouvre|ne ferme pas de trappe.");
        }

        /*****************************************************************************************/
        /****************************** TEST DE DEPENDANCE DES MONDES ****************************/
        /*****************************************************************************************/

        world.ouvrirFermer(7);

        if (etatDepart.getPiece(7).toString().equals(world.getPiece(7).toString())){
            fail("La copie n'est que superficielle.");
        }

    }

    @Test
    void toStringTest() {
        if (!etatDepart.toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le robot n'est pas situé sur la bonne case.");
        }

        // Déclaration du monde
        world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(5,0,1);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(5);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world, 5);

        if (!etatDepart.toString().equals("Numéro : 6 | Trésor : true | Trappe : false")){
            fail("Le robot n'est pas situé sur la bonne case.");
        }
    }

    @Test
    void equals() {
        if (etatDepart.estUnEtatFinal()){
            fail("Le robot ne devrait pas être positionné sur un trésor.");
        }

        // Déclaration du monde
        world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(5,0,1);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world,7);

        if (!etatDepart.estUnEtatFinal()){
            fail("Le robot devrait être positionné sur un trésor.");
        }
    }

    @Test
    void estTombe() {
        if (etatDepart.estTombe()){
            fail("Le robot n'est pas tombé dans une trappe.");
        }

        // Déclaration du monde
        world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(5,0,1);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world, 4);

        if (!etatDepart.estTombe()){
            fail("Le robot est pourtant bel et bien tombé dans une trappe.");
        }

        etatDepart.ouvrirTrappe(4);

        if (etatDepart.estTombe()){
            System.out.println(etatDepart);
            fail("Le robot se situe sur une trappe fermée manuellement.");
        }
    }

    @Test
    void iterator() {
        Iterator<IEtat> it = etatDepart.iterator() ;

        if (!it.hasNext()){
            fail("L'itérateur devrait contenir des états.");
        }
        if (!it.next().toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("L'itérateur ne contient pas les bons états.");
        }
        if (!it.next().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("L'itérateur ne contient pas les bons états.");
        }
        if (it.hasNext()){
            fail("L'itérateur ne devrait pas contenir d'états supplémentaires.");
        }

        /* Testons le résultat lorsque l'on place le robot en case 2 */

        /*        ______ ______ ______
                 |      |      |      |
                 |  1  <-> 2R  |  3P  |      a)   1 <-> 2  active/désactive trappe en 4
                 |__  __|__  __|__  __|      b)   5 <-> 6  active/désactive trappe en 7
                 |      |      |      |
                 |  4*  |  5P <-> 6   |      Legende :
                 |___  _|______|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7*    8T R'|   9  |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ
                                                        - R' = Robot à la fin

         */

        // Déclaration du monde
        world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(3,0,1);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world, 1);

        it = etatDepart.iterator() ;

        if (!it.hasNext()){
            fail("L'itérateur devrait contenir des états.");
        }
        if (!it.next().toString().equals("Numéro : 5 | Trésor : false | Trappe : true")){
            fail("L'itérateur ne contient pas les bons états.");
        }
        if (!it.next().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("L'itérateur ne contient pas les bons états.");
        }
        if (it.hasNext()){
            fail("L'itérateur ne devrait pas contenir d'états supplémentaires.");
        }
    }
}