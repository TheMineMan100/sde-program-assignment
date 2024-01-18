package allegiances;

import board.Square;
import pieces.Piece;

public class White implements Allegiance {
    public void movePawn(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
        if (
            squareToMoveTo.getX() - currentSquare.getX() == 0 &&
            squareToMoveTo.getY() - currentSquare.getY() == 1 &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };

    public void attackWithPawn(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
            ((squareToAttack.getX() - currentSquare.getX() == -1 &&
                squareToAttack.getY() - currentSquare.getY() == 1) ||
            (squareToAttack.getX() - currentSquare.getX() == 1 &&
                squareToAttack.getY() - currentSquare.getY() == 1)) &&
            squareToAttack.getPiece() != null &&
            squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {

        }
    };
}
