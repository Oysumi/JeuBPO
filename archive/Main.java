package projetBPO.archive;

import projetBPO.algos.LargeurDAbord;
import projetBPO.algos.ProfondeurDAbord;
import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.jeudemots.Dictionnaire;
import projetBPO.jeux.jeudemots.JeuDeMots;
import projetBPO.jeux.oups.Monde;
import projetBPO.jeux.oups.Oups;

import java.io.IOException;

/**
 * @author Aurélien
 * @version Decembre 2018
 */
public class Main {
    public static void main(String[] args) {
        /*JeuDeMots jdm = new JeuDeMots("ABAT");
        LargeurDAbord algoLarg = new LargeurDAbord();
        Dictionnaire dico = new Dictionnaire();
        try {
            dico.setMots("../dico4.txt");
        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir le dictionnaire.");
            System.exit(3);
        }
        JeuDeMots.setDictionnaire(dico);
        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("ABOT"));

        ProfondeurDAbord algoProf = new ProfondeurDAbord();*/

        /* *************************************************************************** */

        /*        ______ ______ ______
                 |      |      |      |      a) 1 <-> 2 active 5
                 |  1R      2     3   |      b) 3 <-> 6 active 5
                 |______|__  __|__  __|      c) 5 <-> 6 active 7
                 |      |      |      |
                 |   4     5*     6   |      Legende :
                 |__  __|__  __|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7P*    8T  |   9  |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ


         */

        // Déclaration du monde
        Monde world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(1,2);
        world.ajouterPassage(3,4);
        world.ajouterPassage(3,6);
        world.ajouterPassage(4,7);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(4,0,1);
        world.ajouterOuvertureFermetureTrappe(4,2,5);
        world.ajouterOuvertureFermetureTrappe(6,4,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(6);

        // Déclaration du jeu
        Oups jeuOups = new Oups(world, 0);

        LargeurDAbord algoLarg = new LargeurDAbord();
    }
}
