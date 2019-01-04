package projetBPO.jeux.oups;

import java.util.ArrayList;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class CollectionPassage {

    private ArrayList<Passage> passages ;

    /**
     * Fixe le nombre de passages
     */
    public CollectionPassage(){
        passages = new ArrayList<>(150); // On prévoit un grand nombre de passages
    }

    /**
     * Instancie une collection de passages
     * @param pass tous les passages
     */
    public CollectionPassage(Passage ... pass){
        this();
        for (Passage p : pass){
            passages.add(p);
        }
    }

    /**
     * Copie profonde
     * @param pass collection de passages à copier
     */
    public CollectionPassage(CollectionPassage pass){
        this();
        int size = pass.taille() ;
        for (int i = 0 ; i < size ; i++){
            passages.add(pass.getPassage(i));
        }
    }

    /**
     * Taille de la collection
     * @return le nombre de passages présents dans la collection
     */
    public int taille(){
        return passages.size() ;
    }

    /**
     * Passage numéro i
     * @param numero numéro du passage
     * @return retourne le passage numéro i
     *
     * Ne sera jamais utilisé réellement pour le jeu, ne sert qu'aux tests pour vérifier si tout se passe bien
     * */
    public Passage getPassage(int numero){
        return passages.get(numero);
    }

    /**
     * Ajoute un passage dans la collection
     * @param pass passage à ajouter
     */
    public void ajouterPassage(Passage pass){
        passages.add(pass);
    }
}
