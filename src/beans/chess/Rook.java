package beans.chess;

import beans.inrerfaces.MovablePiece;

public class Rook implements MovablePiece {

    private boolean castled;

    public void setCastled(boolean castled) {
        this.castled = castled;
    }

    public boolean isCastled(){
        return this.castled;
    }

    @Override
    public int getPositionsAfterMove() {
        if(isCastled())
            return 3;
        return 8;
    }

    @Override
    public void move(){
        System.out.println("I can move in straight lines.");
    }
}
