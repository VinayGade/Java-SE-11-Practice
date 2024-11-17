package beans.chess;

import beans.inrerfaces.MovablePiece;

public class Bishop implements MovablePiece {

    @Override
    public int getPositionsAfterMove() {
        return 6;
    }

    @Override
    public void move(){
        System.out.println("I can move diagonally.");
    }
}