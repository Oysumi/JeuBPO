package projetBPO.jeux.jeudemots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class Dictionnaire implements Iterable<String>{

    private ArrayList<String> m_dico ;

    /**
     * Fixe la capacité du dictionnaire
     */
    public Dictionnaire() {
        m_dico = new ArrayList<String>(500);
    }

    /**
     * Création d'un dictionnaire avec mots
     * @param mots mots à écrire dans le dictionnaire
     */
    public Dictionnaire(String ... mots) {
        this();
        setMots(mots);
    }

    /**
     * Ecrit les mots dans le dictionnaire
     * @param mots mots à écrire dans le dictionnaire
     */
    public void setMots(String ... mots) {
        for (String word : mots) {
            m_dico.add(word.toUpperCase());
        }
    }

    /**
     * Ecrit les mots écrits dans un fichier dans le dictionnaire
     * @param nomFichier nom du fichier contenant les mots
     * @throws IOException si impossible de trouver/d'ouvrir le fichier
     */
    public void setMots(String nomFichier) throws IOException{
        FileReader flot ;
        BufferedReader flotFiltre;

        flot = new FileReader(nomFichier);
        flotFiltre = new BufferedReader(flot);
        String ligne = flotFiltre.readLine() ;
        while(ligne != null){
            String[] mots = ligne.split(" ");
            setMots(mots);
            ligne = flotFiltre.readLine();
        }
    }

    /**
     * Le dictionnaire contient-t-il le mot ?
     * @param mot mot éventuellement présent dans le dictionnaire
     * @return vrai si le mot est présent dans le dictionnaire
     */
    public boolean contient(String mot) {
        return m_dico.contains(mot.toUpperCase());
    }

    /**
     * toString du dictionnaire
     * @return une chaîne de caractère contenant tous les mots présent dans le dictionnaire
     */
    public String toString(){
        /* On imagine des mots de 26 lettres, séparés par une virgule et un espace
         * càd 26*(nombre de mots) + nombre de mots*2 = nombre de mots * 28
         */
        StringBuilder temp = new StringBuilder(28*m_dico.size());

        /* On prévoit le cas où notre dictionnaire est vide pour ne pas lancer
         * d'exceptions
         */
        boolean isempty = true;

        for (String word : m_dico){
            temp.append(word);
            temp.append(", ");
            isempty = false ;
        }

        /* On retire la virgule et l'espace en trop à la fin si le dictionnaire
         * n'est pas vide
         */
        if (!isempty) {
            int size = temp.length();
            temp.delete(size - 2, size);
        }

        return temp.toString() ;
    }

    /**
     * Itérateur du dictionnaire
     * @return tous les mots présents dans le dictionnaire
     */
    @Override
    public Iterator<String> iterator() {
        return m_dico.iterator();
    }
}
