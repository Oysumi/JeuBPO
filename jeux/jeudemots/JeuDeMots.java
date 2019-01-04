package projetBPO.jeux.jeudemots;

import projetBPO.jeux.EtatAvecEtatFinalPredefini;
import projetBPO.jeux.IEtat;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class JeuDeMots extends EtatAvecEtatFinalPredefini{

    private StringBuilder mot ;
    private static Dictionnaire dico ;

    /**
     * Fixe le jeu de mot avec un mot de départ
     * @param word mot de départ
     */
    public JeuDeMots(String word){
        // On récupère la taille du mot
        int size = word.length();

        mot = new StringBuilder(size);
        mot.append(word.toUpperCase());
    }

    /**
     * Fixe le dictionnaire
     * @param d dictionnaire
     */
    public static void setDictionnaire(Dictionnaire d){
        dico = d ;
    }

    /**
     * Méthode toString du jeu de mot
     * @return une chaîne de caractère contenant le mot actuel du jeu
     */
    public String toString(){
        return mot.toString();
    }

    /**
     * Est-ce que le mot actuel est égal à un autre mot ?
     * @param etat le mot éventuellement égale
     * @return vrai si les deux mots sont égaux
     */
    public boolean equals(Object etat){
        return toString().equalsIgnoreCase(etat.toString());
    }

    /**
     * Itérateur du jeu de mot
     * @return tous les mots existants dans le dictionnaire obtenus en ne changeant qu'une lettre
     */
    public Iterator<IEtat> iterator(){
        int size = mot.length();
        int index = 0 ;
        ArrayList<IEtat> succ = new ArrayList<IEtat>(26*size);

        /* Nous allons modifier les caractères du mot un par un, tout en sauvegardant le mot de départ
         * pour le restaurer à chaque fin d'itération
         */
        while (index < size){
            String save = mot.toString();
            mot.replace(index, index+1, "a");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"b");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"c");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"d");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"e");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"f");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"g");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"h");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"i");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"j");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"k");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"l");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"m");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"n");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"o");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"p");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"q");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"r");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"s");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"t");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"u");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"v");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"w");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"x");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"y");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(index,index+1,"z");
            if (dico.contient(mot.toString()) && !mot.toString().equalsIgnoreCase(save)){
                succ.add(new JeuDeMots(mot.toString()));
            }
            mot.replace(0, size, save);
            index++;
        }

        return succ.iterator();
    }
}
