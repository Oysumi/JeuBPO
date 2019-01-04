package projetBPO.jeux.oups;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class Monde {

    private CollectionPiece collecPiece ;

    /**
     * Fixe le monde avec un nombre de salles
     * @param nbSalles nombre de salles
     */
    public Monde(int nbSalles){
        collecPiece = new CollectionPiece(nbSalles);
    }

    /**
     * Constructeur de copie
     * @param world monde à copier
     */
    public Monde(Monde world){
        collecPiece = new CollectionPiece(world.getCollection());
    }

    /**
     * Nombre de salles du monde
     * @return le nombre de salles du monde
     */
    public int nbSalles(){
        return collecPiece.nbSalles();
    }

    /**
     * Ajoute un passage entre deux salles
     * @param noSalleUn première salle du passage
     * @param noSalleDeux seconde salle du passage
     */
    public void ajouterPassage(int noSalleUn, int noSalleDeux){
        Piece pieceUne = collecPiece.getPiece(noSalleUn);
        Piece pieceDeux = collecPiece.getPiece(noSalleDeux);
        Passage passUn = new Passage(pieceUne, pieceDeux);
        Passage passDeux = new Passage(pieceDeux, pieceUne);
        pieceUne.ajouterPassage(passUn);
        pieceDeux.ajouterPassage(passDeux);
    }

    /**
     * Ajoute un passage piégé entre deux salles
     * @param noSalleTrappe numéro de la salle dont la trappe doit s'ouvrir / se fermer
     * @param noSalleUn première salle du passage
     * @param noSalleDeux seconde salle du passage
     */
    public void ajouterOuvertureFermetureTrappe(int noSalleTrappe, int noSalleUn, int noSalleDeux){
        Piece pieceUne = collecPiece.getPiece(noSalleUn);
        Piece pieceDeux = collecPiece.getPiece(noSalleDeux);

        Passage passUn = new Passage(pieceUne, pieceDeux, noSalleTrappe);
        Passage passDeux = new Passage(pieceDeux, pieceUne, noSalleTrappe);

        pieceUne.ajouterPassage(passUn);
        pieceDeux.ajouterPassage(passDeux);
    }

    /**
     * Ajoute un trésor dans une salle
     * @param noSalle numéro de la salle dans laquelle on ajoute le trésor
     */
    public void ajouterTresor(int noSalle){
        collecPiece.ajouterTresor(noSalle);
    }

    /**
     * Ouvre / ferme une trappe
     * @param noSalle numéro de la salle dont la trappe doit s'ouvrir / se fermer
     */
    public void ouvrirFermer(int noSalle){
        collecPiece.ouvrirFermer(noSalle);
    }

    /**
     * Getter de pièce
     * @param noPiece numéro de la pièce à récuperer
     * @return la pièce souhaitée
     * Ne sera jamais utilisé dans le jeu mais est utile aux tests
     */
    public Piece getPiece(int noPiece){
        return collecPiece.getPiece(noPiece);
    }

    /**
     * Getter de collection
     * @return la collection de pièce du monde
     * N'est utile que pour le constructeur de copie profonde
     */
    public CollectionPiece getCollection(){
        return collecPiece ;
    }
}
