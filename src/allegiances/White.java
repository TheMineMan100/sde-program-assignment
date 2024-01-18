package allegiances;

import board.Square;
import pieces.Piece;

public class White implements Allegiance {
    public void movePawn(Square currentSquare, Square squareToMoveTo) {
        if (
            squareToMoveTo.getX() - currentSquare.getX() == 0 &&
            squareToMoveTo.getY() - currentSquare.getY() == 1 &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };
}
