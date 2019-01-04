package projetBPO.tests.TestAlgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.algos.ProfondeurDAbord;
import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.oups.Monde;
import projetBPO.jeux.oups.Oups;

import static org.junit.jupiter.api.Assertions.*;

class ProfondeurDAbordTestOups {
    private Oups etatDepart ;
    private ProfondeurDAbord algo ;

    @BeforeEach
    void setUp(){
        /*        ______ ______ ______
                 |      |      |      |
                 |  1R  |   2  |  3P  |
                 |__  __|__  __|__  __|
                 |      |      |      |
                 |   4  |  5P     6*  |      Legende :
                 |___  _|______|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7*    8T R'|   9  |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ
                                                        - R' = Robot à la fin

         */

        // Déclaration du monde
        Monde world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);

        // Déclaration du jeu
        etatDepart = new Oups(world, 0);

        algo = new ProfondeurDAbord() ;
    }

    @Test
    void testRechercheVraiSansOuvertureFermeture(){
        if (!algo.existeChemin(etatDepart)){
            fail("Il existe pourtant un chemin vers le trésor.");
        }
    }

    @Test
    void testRechercheFauxSansOuvertureFermeture(){
        // Déclaration du monde
        Monde world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,3);
        world.ajouterPassage(3,6);
        world.ajouterPassage(6,7);
        world.ajouterPassage(2,5);
        world.ajouterPassage(1,4);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(7);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(2);
        world.ouvrirFermer(4);
        world.ouvrirFermer(3); /* ON AJOUTE UNE TRAPPE OUVERTE DANS LA PIECE 4 */

        // Déclaration du jeu
        etatDepart = new Oups(world, 1);

        /*        ______ ______ ______
                 |      |      |      |
                 |  1R      2  |  3P  |
                 |__  __|__  __|__  __|
                 |      |      |      |
                 |  4P  |  5P     6*  |      Legende :
                 |___  _|______|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7*    8T R'|   9  |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ
                                                        - R' = Robot à la fin

         */

        if (algo.existeChemin(etatDepart)){
            fail("Il ne devrait pas exister de chemin vers le trésor.");
        }
    }

    @Test
    void testRechercheVraiAvecOuvertureFermeture(){

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
        etatDepart = new Oups(world, 0);

        if (!algo.existeChemin(etatDepart)){
            fail("Il devrait exister un chemin vers le trésor.");
        }
    }

    @Test
    void testRechercheFauxAvecOuvertureFermeture(){
        /*        ______ ______ ______
                 |      |      |      |      a) 2 <-> 5 active 4
                 |  1R      2     3   |      b) 3 <-> 6 active 4
                 |______|__  __|__  __|
                 |      |      |      |
                 |  4*      5     6   |      Legende :
                 |__  __|__  __|__  __|                 - P = Piège
                 |      |      |      |                 - T = Trésor
                 |  7T     8P  |  9   |                 - * = Piège activé/désactivé par un passage
                 |______|______|______|                 - R = Robot au départ


         */

        // Déclaration du monde
        Monde world = new Monde(9);

        // Inscription dans le monde des passages qui n'activent pas de pièges
        world.ajouterPassage(0,1);
        world.ajouterPassage(1,2);
        world.ajouterPassage(3,4);
        world.ajouterPassage(4,5);
        world.ajouterPassage(3,6);
        world.ajouterPassage(4,7);
        world.ajouterPassage(5,8);

        // Inscription dans le monde des passages qui activent des pièges
        world.ajouterOuvertureFermetureTrappe(3,1,4);
        world.ajouterOuvertureFermetureTrappe(3,2,5);

        // Inscription dans le monde des salles contenant un trésor
        world.ajouterTresor(6);

        // Inscription dans le monde des salles avec des trappes ouvertes dès le départ
        world.ouvrirFermer(7);

        // Déclaration du jeu
        etatDepart = new Oups(world, 0);

        if (algo.existeChemin(etatDepart)){
            fail("Il ne devrait pas exister de chemin vers le trésor.");
        }
    }
}