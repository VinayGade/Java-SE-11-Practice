package beans.chess;

import beans.inrerfaces.MovablePiece;

public class Queen implements MovablePiece {

    @Override
    public int getPositionsAfterMove() {
        return 4;
    }

    @Override
    public void move(){
        System.out.println("I move in any direction. I can move like Rook and Bishop.");
    }
}
