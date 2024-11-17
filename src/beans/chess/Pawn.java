package beans.chess;

import beans.inrerfaces.MovablePiece;

public class Pawn implements MovablePiece {

    @Override
    public int getPositionsAfterMove() {
        return 1;
    }

    @Override
    public void move(){
        System.out.println("I can only move forward.");
    }
}
