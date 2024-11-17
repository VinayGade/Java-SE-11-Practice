package beans.inrerfaces;

public interface MovablePiece {

    /*
    Chess game:
    single movable piece in chess (like pawn, rook, bishop, knight, queen)
    */
    abstract int getPositionsAfterMove();
    default void move(){
        System.out.println("I'm moving");
    }

    private static void die(){
        System.out.println("\nEventhough This piece dies, game continues. " +
                "\nQueen can re-born under certain circumstances of pawn.");
    }

    static void death(){
        System.out.println("\n This Piece is dead now.");
        die();
    }
}
