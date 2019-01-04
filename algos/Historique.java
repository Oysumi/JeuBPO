package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.ArrayList;

/**
 * @author Aurélien
 * @version Décembre 2018
 */

public class Historique {

    private ArrayList<IEtat>  histo ;

    /**
     * Création de l'historique
     */
    public Historique(){
        histo = new ArrayList<>(250); // On préfère donner une grande capacité au départ
    }

    /**
     * Ajout dans l'historique d'un état
     * @param etat état à ajouter dans l'historique
     */
    public void ajouter(IEtat etat){
        histo.add(etat);
    }

    /**
     * Contient oui ou non l'état
     * @param etat état éventuellement contenu dans l'historique
     * @return vrai si l'historique contient l'état
     */
    public boolean contient(IEtat etat){
        return histo.contains(etat);
    }
}
