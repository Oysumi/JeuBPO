package projetBPO.algos;

import projetBPO.jeux.IEtat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class LargeurDAbord implements IRecherche {

    /**
     * Existe-t-il un chemin entre l'état actuel et celui passé en paramètre ?
     * @param etat état à atteindre
     * @return vrai s'il existe un chemin
     */
    public boolean existeChemin(IEtat etat){
        Historique hist = new Historique();
        return existeChemin(etat, hist);
    }

    /**
     * Existe-t-il un chemin entre l'état actuel et celui passé en paramètre (sans boucles) ?
     * @param etat état à atteindre
     * @param histo historique des déplacements
     * @return vrai s'il existe un chemin sans boucle
     */
    private boolean existeChemin(IEtat etat, Historique histo){
        boolean trouve = etat.estFinal() ;
        boolean cyclique ;
        Queue<IEtat> file = new LinkedList<IEtat>();
        file.add(etat);

        while (!file.isEmpty() && !trouve){
            IEtat actuel = file.poll();
            trouve = actuel.estFinal();
            cyclique = histo.contient(actuel);
            histo.ajouter(actuel);
            Iterator<IEtat> iter = actuel.iterator();

            if (!cyclique) {
                while (iter.hasNext()) {
                    IEtat succ = iter.next();
                    file.add(succ);
                }
            }
        }

        return trouve ;
    }
}
