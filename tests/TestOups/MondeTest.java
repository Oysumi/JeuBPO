package projetBPO.tests.TestOups;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.jeux.oups.Monde;
import projetBPO.jeux.oups.Piece;

import static org.junit.jupiter.api.Assertions.*;

class MondeTest {

    private Monde monMonde ;

    @BeforeEach
    void setUp(){
       monMonde = new Monde(9);

       /*         ______ ______ ______
                 |      |      |      |
                 |   1  |   2  |   3  |
                 |______|______|______|
                 |      |      |      |
                 |   4  |   5  |   6  |
                 |______|______|______|
                 |      |      |      |
                 |   7  |   8  |   9  |
                 |______|______|______|

         */
    }

    @Test
    void testCopie(){
        Monde newWorld = new Monde(monMonde);
        for (int i = 1 ; i < monMonde.nbSalles() ; i++){
            if (!newWorld.getPiece(i).toString().equals(monMonde.getPiece(i).toString())){
                fail("La copie de monde ne s'est pas bien réalisée.");
            }
        }

        monMonde.ouvrirFermer(8);

        if (newWorld.getPiece(8).toString().equals(monMonde.getPiece(8))) {
            fail("La copie n'est que supérificielle.");
        }
    }

    @Test
    void instanciation(){
        if (monMonde.nbSalles() != 9){
            fail("Le monde ne contient pas 9 salles mais : " + monMonde.nbSalles() + " salles.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(0).toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(0).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(1).toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(1).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(2).toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(2).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(3).toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(3).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(4).toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(4).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(5).toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(5).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(6).toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(6).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(7).toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(7).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }

        /*******************************************************************************************************/

        if (!monMonde.getPiece(8).toString().equals("Numéro : 9 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
        if (monMonde.getPiece(8).nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes pièces.");
        }
    }

    @Test
    void ajouterPassage() {

        /*        ______ ______ ______
                 |      |      |      |
                 |   1      2      3  |
                 |______|__  __|__  __|
                 |      |      |      |
                 |   4  |   5      6  |
                 |______|__  __|______|
                 |      |      |      |
                 |   7      8  |   9  |
                 |______|______|______|

         */

        monMonde.ajouterPassage(0,1);
        monMonde.ajouterPassage(1,2);
        monMonde.ajouterPassage(2,5);
        monMonde.ajouterPassage(1,4);
        monMonde.ajouterPassage(4,5);
        monMonde.ajouterPassage(4,7);
        monMonde.ajouterPassage(7,6);

        Piece res ;

        /*******************************************************************************************************/

        res = monMonde.getPiece(0) ;
        if (res.getNumero() != 1){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.nbPassages() != 1){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(1) ;
        if (res.nbPassages() != 3){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 2){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(2).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(2).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(2) ;
        if (res.nbPassages() != 2){
            fail("La salle ne contient pas le bon nombre de passages : " + res.nbPassages());
        }
        if (res.getNumero() != 3){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(3) ;
        if (res.nbPassages() != 0){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 4){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(4) ;
        if (res.nbPassages() != 3){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 5){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(2).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(2).secondeSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(5) ;
        if (res.nbPassages() != 2){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 6){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(6) ;
        if (res.nbPassages() != 1){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 7){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(7) ;
        if (res.nbPassages() != 2){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 8){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }
        if (res.getPassage(0).activePiege()){
            fail("Le passage n'active pas de trappe.");
        }
        if (res.getPassage(0).activeTrappe() != -1){
            fail("Le passage n'active pas de trappe.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le passage n'est pas le bon.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(8) ;
        if (res.nbPassages() != 0){
            fail("La salle ne contient pas le bon nombre de passages.");
        }
        if (res.getNumero() != 9){
            fail("La salle du monde ne porte pas le bon numéro.");
        }
        if (res.trappeOuverte()){
            fail("Le monde ne contient pas les bonnes salles (trappes).");
        }
        if (res.estUnTresor()){
            fail("Le monde ne contient pas les bonnes salles (trésors).");
        }

    }

    @Test
    void ajouterTresor() {

        /*        ______ ______ ______
                 |      |      |      |
                 |   1      2     3T  |
                 |______|__  __|__  __|
                 |      |      |      |
                 |   4  |  5T      6  |
                 |______|__  __|______|
                 |      |      |      |
                 |  7T      8  |   9  |
                 |______|______|______|

         */

        monMonde.ajouterTresor(2);
        monMonde.ajouterTresor(4);
        monMonde.ajouterTresor(6);

        Piece res ;

        /*******************************************************************************************************/

        res = monMonde.getPiece(0);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(1);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(2);
        if (!res.estUnTresor()){
            fail("Cette pièce est un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(3);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(4);
        if (!res.estUnTresor()){
            fail("Cette pièce est un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(5);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(6);
        if (!res.estUnTresor()){
            fail("Cette pièce est un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(7);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(8);
        if (res.estUnTresor()){
            fail("Cette pièce n'est pas un trésor.");
        }
    }

    @Test
    void ajouterOuvertureFermetureTest(){

        /*        ______ ______ ______
                 |      |      |      |
                 |   1      2  |   3  |      a)   1 -> 2  active trappe en 4
                 |______|______|__  __|      b)   5 -> 6  active trappe en 7
                 |      |      |      |      c)   3 -> 6  active trappe en 9
                 |   4  |   5      6  |
                 |______|______|______|
                 |      |      |      |
                 |   7  |   8  |   9  |
                 |______|______|______|

         */

        monMonde.ajouterOuvertureFermetureTrappe(3,0,1);
        monMonde.ajouterOuvertureFermetureTrappe(6,4,5);
        monMonde.ajouterOuvertureFermetureTrappe(8,2,5);

        Piece res ;

        /*******************************************************************************************************/

        res = monMonde.getPiece(0);
        if (!res.toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 1){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(0).activeTrappe() != 3){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(1);
        if (!res.toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 1){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 2 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 1 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(0).activeTrappe() != 3){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(2);
        if (!res.toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 1){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(0).activeTrappe() != 8){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(3);
        if (!res.toString().equals("Numéro : 4 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(4);
        if (!res.toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 1){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(0).activeTrappe() != 6){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(5);
        if (!res.toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 2){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
        if (!res.getPassage(0).premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).secondeSalle().toString().equals("Numéro : 5 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(0).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(0).activeTrappe() != 6){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }
        if (!res.getPassage(1).premiereSalle().toString().equals("Numéro : 6 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(1).secondeSalle().toString().equals("Numéro : 3 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bons passages.");
        }
        if (!res.getPassage(1).activePiege()){
            fail("Le monde ne contient pas les bons passages (qui devraient activer des pièges.");
        }
        if (res.getPassage(1).activeTrappe() != 8){
            fail("Le monde ne contient pas les bons passages (le numéro de la trappe à activer n'est pas bon).");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(6);
        if (!res.toString().equals("Numéro : 7 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(7);
        if (!res.toString().equals("Numéro : 8 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }

        /*******************************************************************************************************/

        res = monMonde.getPiece(8);
        if (!res.toString().equals("Numéro : 9 | Trésor : false | Trappe : false")){
            fail("Le monde ne contient pas les bonnes salles.");
        }
        if (res.nbPassages() != 0){
            fail("Le monde ne contient pas les bonnes salles avec les bons passages.");
        }
    }

    @Test
    void ouvrirFermerTest(){
        Piece res = monMonde.getPiece(0);
        if (res.trappeOuverte()){
            fail("La trappe doit être fermée.");
        }

        monMonde.ouvrirFermer(0);

        if(!res.trappeOuverte()){
            fail("La trappe doit être maintenant ouverte.");
        }
    }
}