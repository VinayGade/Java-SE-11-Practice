package default_static;

import beans.chess.*;
import beans.inrerfaces.MovablePiece;

public class ChessGameDemo {

    public static void main(String[] args) {

        MovablePiece bishop = new Bishop();
        MovablePiece pawn = new Pawn();
        MovablePiece queen = new Queen();
        Rook rook = new Rook();
        MovablePiece knight = new Knight();

        rook.setCastled(true);

        bishop.move();
        pawn.move();
        queen.move();
        rook.move();
        knight.move();

        System.out.println("Chess Pieces after moving");

        System.out.println("Bishop moved "+bishop.getPositionsAfterMove()+" steps.");
        System.out.println("pawn moved "+pawn.getPositionsAfterMove()+" steps.");
        System.out.println("queen moved "+queen.getPositionsAfterMove()+" steps.");
        System.out.println("knight moved "+knight.getPositionsAfterMove()+" steps.");
        System.out.println("rook is castled? "+rook.isCastled());
        System.out.println("rook moved "+rook.getPositionsAfterMove()+" steps.");

        MovablePiece.death();

    }

    public int callAbstractMethod(MovablePiece piece){
        return piece.getPositionsAfterMove();
    }
}
