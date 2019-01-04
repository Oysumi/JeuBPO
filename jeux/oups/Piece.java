package projetBPO.jeux.oups;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class Piece {

    private int numero ;
    private boolean tresor;
    private boolean trappe;
    private CollectionPassage collecPass ;

    /**
     * Constructeur de pièce
     * @param num numéro de la pièce
     */
    public Piece(int num){
        numero = num ;
        tresor = false ;
        trappe = false ;
        collecPass = new CollectionPassage();
    }

    /**
     * Constructeur de pièce
     * @param tres vrai si la pièce contient un trésor
     * @param trap vrai si la trappe de la pièce est ouverte
     * @param num numéro de la pièce
     */
    public Piece(boolean tres, boolean trap, int num){
        this(num);
        tresor = tres;
        trappe = trap;
    }

    /**
     * Constructeur de copie profonde
     * @param salle pièce à copier
     */
    public Piece(Piece salle){
        numero = salle.getNumero() ;
        tresor = salle.estUnTresor() ;
        trappe = salle.trappeOuverte() ;
        collecPass = new CollectionPassage(salle.getCollecPass());
    }

    /**
     * Change l'état actuel de la trappe
     */
    public void changeTrappe(){
        trappe = !trappe ;
    }

    /**
     * Ajoute un trésor dans la pièce actuelle
     */
    public void ajouteTresor() { tresor = true ; }

    /**
     * @return le numéro de la pièce actuelle
     */
    public int getNumero(){
        return numero;
    }

    /**
     * @return vrai si la trappe de la pièce est ouverte
     */
    public boolean trappeOuverte(){
        return trappe;
    }

    /**
     * @return vrai si la pièce contient un trésor
     */
    public boolean estUnTresor(){
        return tresor;
    }

    /**
     * @return une description de la pièce
     */
    public String toString() {
        return "Numéro : " + numero + " | Trésor : " + tresor + " | Trappe : " + trappe ;
    }

    /**
     * @return le nombre de passages reliant cette pièce à d'autres
     */
    public int nbPassages() { return collecPass.taille() ; }

    /**
     * Ajoute un passage entre cette pièce et une autre
     * @param pass passage à ajouter
     */
    public void ajouterPassage(Passage pass){
        collecPass.ajouterPassage(pass);
    }

    /**
     * Getter de collection de passages (utile au constructeur de copie profonde et aux tests)
     * @return la collection de passages
     */
    public CollectionPassage getCollecPass(){
        return collecPass;
    }

    /**
     * Getter de passage
     * @param numero numéro du passage
     * @return le passage de numéro 'numéro'
     *
     * Ne sera jamais utilisé en pratique dans le jeu, mais sert aux tests
     */
    public Passage getPassage(int numero){
        return collecPass.getPassage(numero);
    }
}
