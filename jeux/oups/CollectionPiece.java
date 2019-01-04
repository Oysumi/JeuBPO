package projetBPO.jeux.oups;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class CollectionPiece {

    private Piece[] collection ;

    /**
     * Créer une collection de pièces avec une taille passée en paramètre
     * @param taille nombre de pièces de la collection
     */
    public CollectionPiece(int taille) {
        collection = new Piece[taille] ;
        for (int i = 0 ; i < taille ; i++){
            collection[i] = new Piece(i+1);
        }
    }

    /**
     * Fixe la collection avec les pièces passées en paramètre
     * @param salles pièces à fixer
     */
    public CollectionPiece(Piece ... salles){
        collection = salles ;
    }

    /**
     * Constructeur de copie profonde
     * @param aCopier collection de pièce à copier
     */
    public CollectionPiece(CollectionPiece aCopier){
        int size = aCopier.nbSalles() ;
        collection = new Piece[size] ;
        for (int i = 0 ; i < size ; i++){
            collection[i] = new Piece(aCopier.getPiece(i));
        }
    }

    /**
     * Ouvre et ferme les trappes des pièces
     * @param numero numéro de la pièce dont la trappe doit s'ouvrir / se fermer
     * @throws IndexOutOfBoundsException si numéro < 0 ou numéro > taille de la collection
     */
    public void ouvrirFermer(int numero) throws IndexOutOfBoundsException{
        collection[numero].changeTrappe();
    }

    /**
     * @return la taille de la collection (le nombre de pièces)
     */
    public int nbSalles(){
        return collection.length ;
    }

    /**
     * Pièce numéro i
     * @param numero numéro de la pièce à retourner
     * @return la pièce de numéro i
     * @throws IndexOutOfBoundsException si numéro < 0 ou numéro > taille
     */
    public Piece getPiece(int numero) throws IndexOutOfBoundsException{
        return collection[numero] ;
    }

    /**
     * Ajoute un trésor dans la pièce n°numéro
     * @param numero numéro de la pièce dans laquelle on doit ajouter le trésor
     * @throws IndexOutOfBoundsException si numéro < 0 ou numéro > taille
     */
    public void ajouterTresor(int numero) throws IndexOutOfBoundsException{
        collection[numero].ajouteTresor();
    }
}
