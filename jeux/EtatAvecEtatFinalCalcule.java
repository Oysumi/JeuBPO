package projetBPO.jeux;

/**
 * @version Decembre 2018
 * @author Aurélien
 */
public abstract class EtatAvecEtatFinalCalcule implements IEtat {

    /**
     * Calcule si l'on est sur un état final
     * @return vrai si l'état est final
     */
    @Override
    public boolean estFinal() {
        return this.estUnEtatFinal();
    }

    /**
     * Méthode à redéfinir pour savoir si l'état est final
     */
    public abstract boolean estUnEtatFinal() ;
}
