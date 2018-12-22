package projetBPO.jeux.oups;

public class Monde {

    private CollectionPiece collecPiece ;

    public Monde(int nbSalles){
        collecPiece = new CollectionPiece(nbSalles);
    }

    public int nbSalles(){
        return collecPiece.nbSalles();
    }

    public void ajouterPassage(int noSalleUn, int noSalleDeux){
        Piece pieceUne = collecPiece.getPiece(noSalleUn);
        Piece pieceDeux = collecPiece.getPiece(noSalleDeux);
        Passage passUn = new Passage(pieceUne, pieceDeux);
        Passage passDeux = new Passage(pieceDeux, pieceUne);
        pieceUne.ajouterPassage(passUn);
        pieceDeux.ajouterPassage(passDeux);
    }

    public void ajouterOuvertureFermeture(int noSalleTrappe, int noSalleUn, int noSalleDeux){
        Piece pieceUne = collecPiece.getPiece(noSalleUn);
        Piece pieceDeux = collecPiece.getPiece(noSalleDeux);

        Passage passUn = new Passage(pieceUne, pieceDeux, noSalleTrappe);
        Passage passDeux = new Passage(pieceDeux, pieceUne, noSalleTrappe);

        pieceUne.ajouterPassage(passUn);
        pieceDeux.ajouterPassage(passDeux);
    }

    public void ajouterTresor(int noSalle){
        collecPiece.ajouterTresor(noSalle);
    }

    public void ouvrirFermer(int noSalle){
        collecPiece.ouvrirFermer(noSalle);
    }

    /* Ne sera jamais utilisé dans le jeu mais est utile aux tests */
    public Piece getPiece(int noPiece){
        return collecPiece.getPiece(noPiece);
    }
}
