package projetBPO.tests.TestAlgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetBPO.algos.ProfondeurDAbord;
import projetBPO.jeux.jeudemots.Dictionnaire;
import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.jeudemots.JeuDeMots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class ProfondeurDAbordTestJeuDeMot {

    private ProfondeurDAbord algo ;
    private JeuDeMots jdm ;
    private Dictionnaire dico ;

    @BeforeEach
    void setUp(){
        algo = new ProfondeurDAbord();
        jdm = new JeuDeMots("abat");
        dico = new Dictionnaire();
        try {
            dico.setMots("../dico4.txt");
        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir le dictionnaire.");
            System.exit(3);
        }
        JeuDeMots.setDictionnaire(dico);
        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("ABOT"));
    }

    @Test
    void testRechercheVrai(){

        long startTime = System.nanoTime();
        if (!algo.existeChemin(jdm)) {
            fail("Il existe un chemin vers ce mot.");
        }
        long estimatedTime = System.nanoTime() - startTime ;

        try{
            FileWriter flot = new FileWriter("resultats.txt", true);
            BufferedWriter flotFiltreUn = new BufferedWriter(flot);
            PrintWriter flotFiltreDeux = new PrintWriter(flotFiltreUn);
            flotFiltreDeux.println("PROFONDEUR D'ABORD VRAI (ABOT) : " + estimatedTime +"ns.");
            flotFiltreDeux.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire les résultats des tests.");
            System.exit(3);
        }

        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("IXAT"));

        startTime = System.nanoTime();
        if (!algo.existeChemin(jdm)) {
            fail("Il existe un chemin vers ce mot.");
        }
        estimatedTime = System.nanoTime() - startTime ;

        try{
            FileWriter flot = new FileWriter("resultats.txt", true);
            BufferedWriter flotFiltreUn = new BufferedWriter(flot);
            PrintWriter flotFiltreDeux = new PrintWriter(flotFiltreUn);
            flotFiltreDeux.println("PROFONDEUR D'ABORD VRAI (IXAT) : " + estimatedTime +"ns.");
            flotFiltreDeux.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire les résultats des tests.");
            System.exit(3);
        }
    }

    @Test
    void testRechercheFaux(){
        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("JABO"));

        long startTime = System.nanoTime();
        if (algo.existeChemin(jdm)) {
            fail("Il n'existe pas de chemin vers ce mot.");
        }
        long estimatedTime = System.nanoTime() - startTime ;

        try{
            FileWriter flot = new FileWriter("resultats.txt", true);
            BufferedWriter flotFiltreUn = new BufferedWriter(flot);
            PrintWriter flotFiltreDeux = new PrintWriter(flotFiltreUn);
            flotFiltreDeux.println("PROFONDEUR D'ABORD FAUX (JABO) : " + estimatedTime +"ns.");
            flotFiltreDeux.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire les résultats des tests.");
            System.exit(3);
        }

        EtatAvecEtatFinalPredefini.setEtatFinal(new JeuDeMots("KAMO"));

        startTime = System.nanoTime();
        if (algo.existeChemin(jdm)) {
            fail("Il n'existe pas de chemin vers ce mot.");
        }
        estimatedTime = System.nanoTime() - startTime ;

        try{
            FileWriter flot = new FileWriter("resultats.txt", true);
            BufferedWriter flotFiltreUn = new BufferedWriter(flot);
            PrintWriter flotFiltreDeux = new PrintWriter(flotFiltreUn);
            flotFiltreDeux.println("PROFONDEUR D'ABORD FAUX (KAMO) : " + estimatedTime +"ns.");
            flotFiltreDeux.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire les résultats des tests.");
            System.exit(3);
        }
    }
}