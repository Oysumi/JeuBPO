package projetBPO.jeux.oups;

/**
 * @author Aurélien
 * @version Décembre 2018
 */
public class Passage {

    private Piece salleUne ;
    private Piece salleDeux ;
    private boolean activeTrappe = false ; // Permet de savoir si ce passage active une trappe
    private int numSalleTrappe = -1 ; // Trappe à activer au cas où le passage active un piège

    /**
     * Création d'un passage entre deux pièces
     * @param premiereSalle première salle du passage
     * @param secondeSalle seconde salle du passage
     */
    public Passage(Piece premiereSalle, Piece secondeSalle){
        salleUne = premiereSalle ;
        salleDeux = secondeSalle ;
    }

    /**
     * Création d'un passage qui active une trappe
     * @param premiereSalle première salle du passage
     * @param secondeSalle seconde salle du passage
     * @param noSalleTrappe salle dont la trappe doit être activée
     */
    public Passage(Piece premiereSalle, Piece secondeSalle, int noSalleTrappe){
        this(premiereSalle, secondeSalle) ;
        ajouterPiege(noSalleTrappe);
    }

    /**
     * Constructeur de copie profonde
     * @param pass passage à copier
     */
    public Passage(Passage pass){
        salleUne = new Piece(pass.premiereSalle());
        salleDeux = new Piece(pass.secondeSalle());
        activeTrappe = pass.activePiege() ;
        numSalleTrappe = pass.activeTrappe() ;
    }

    /**
     * Fixe le passage en tant que passage piège qui active une trappe
     * @param sallePiege numéro de la salle dont la trappe doit s'ouvrir / se fermer
     */
    public void ajouterPiege(int sallePiege){
        activeTrappe = true ;
        numSalleTrappe = sallePiege ;
    }

    /**
     * @return vrai si le passage active un piège
     */
    public boolean activePiege(){
        return activeTrappe ;
    }

    /**
     * @return le numéro de la salle dont la trappe doit s'ouvrir (-1 si le passage n'active pas de trappe)
     */
    public int activeTrappe(){
        return numSalleTrappe ;
    }

    /**
     * @return la première salle du passage
     */
    public Piece premiereSalle(){
        return salleUne ;
    }

    /**
     * @return la seconde salle du passage
     */
    public Piece secondeSalle(){
        return salleDeux ;
    }
}
