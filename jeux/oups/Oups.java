package projetBPO.jeux.oups;

public class Oups {

    private static Monde world ;
    private Piece robot ;

    public Oups(Monde myWorld, Piece salleRobot){
        world = myWorld ;
        robot = salleRobot ;
    }

    public void ouvrirTrappe(int noSalle){
        world.ouvrirFermer(noSalle);
    }
}
