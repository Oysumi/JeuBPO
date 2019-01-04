package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.Iterator;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class ProfondeurDAbord implements IRecherche {

    /**
     * Existe-t-il un chemin entre l'état actuel et celui passé en paramètre ?
     * @param etat état à atteindre
     * @return vrai s'il existe un chemin
     */
    public boolean existeChemin(IEtat etat){
        Historique histo = new Historique();
        return existeChemin(etat, histo);
    }

    /**
     * Existe-t-il un chemin entre l'état actuel et celui passé en paramètre (sans boucles) ?
     * @param etat état à atteindre
     * @param h historique des déplacements
     * @return vrai s'il existe un chemin sans boucle
     */
    private boolean existeChemin(IEtat etat, Historique h){

        boolean trouve = etat.estFinal();
        boolean cyclique ;
        h.ajouter(etat);
        Iterator<IEtat> iterator = etat.iterator();

        while (!trouve && iterator.hasNext()){
            IEtat e = iterator.next() ;
            cyclique = h.contient(e);
            if (!cyclique) {
                trouve = existeChemin(e, h);
            }
        }

        return trouve ;
    }
}
