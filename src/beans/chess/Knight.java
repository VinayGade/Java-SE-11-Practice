package beans.chess;

import beans.inrerfaces.MovablePiece;

public class Knight implements MovablePiece {

    @Override
    public int getPositionsAfterMove() {
        return 2;
    }

    @Override
    public void move(){
        System.out.println("I move in a different way. I can move in L shape.");
    }
}
