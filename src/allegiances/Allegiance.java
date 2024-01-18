package allegiances;

import board.Square;

public interface Allegiance {
    public void movePawn(Square currentSquare, Square squareToMoveTo);

    public default void moveKnight(Square currentSquare, Square squareToMoveTo) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 2) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -2) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 2 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 2 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 2) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -2) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -2 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -2 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -1)
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };

    public default void moveBishop(Square currentSquare, Square squareToMoveTo) {
        if (
            (
                squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                squareToMoveTo.getY() - currentSquare.getY() != 0 &&
                squareToMoveTo.getX() - currentSquare.getX() == squareToMoveTo.getY() - currentSquare.getY()
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };

    public default void moveRook(Square currentSquare, Square squareToMoveTo) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() != 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0)
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };

    public default void moveQueen(Square currentSquare, Square squareToMoveTo) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() != 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0) ||
                (
                    squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() != 0 &&
                    squareToMoveTo.getX() - currentSquare.getX() == squareToMoveTo.getY() - currentSquare.getY()
                )
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };

    public default void moveKing(Square currentSquare, Square squareToMoveTo) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == -1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() == -1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 1) ||
                (squareToMoveTo.getX() - currentSquare.getX() == 1 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 1)
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            squareToMoveTo.setPiece(currentSquare.getPiece());
            currentSquare.setPiece(null);
        }
    };
}
