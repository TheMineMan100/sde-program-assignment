package allegiances;

import board.Square;

public interface Allegiance {
    public void movePawn(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween);

    public void attackWithPawn(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween);

    public default void moveKnight(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
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

    public default void attackWithKnight(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
            (
                (squareToAttack.getX() - currentSquare.getX() == 1 &&
                    squareToAttack.getY() - currentSquare.getY() == 2) ||
                (squareToAttack.getX() - currentSquare.getX() == 1 &&
                    squareToAttack.getY() - currentSquare.getY() == -2) ||
                (squareToAttack.getX() - currentSquare.getX() == 2 &&
                    squareToAttack.getY() - currentSquare.getY() == 1) ||
                (squareToAttack.getX() - currentSquare.getX() == 2 &&
                    squareToAttack.getY() - currentSquare.getY() == -1) ||
                (squareToAttack.getX() - currentSquare.getX() == -1 &&
                    squareToAttack.getY() - currentSquare.getY() == 2) ||
                (squareToAttack.getX() - currentSquare.getX() == -1 &&
                    squareToAttack.getY() - currentSquare.getY() == -2) ||
                (squareToAttack.getX() - currentSquare.getX() == -2 &&
                    squareToAttack.getY() - currentSquare.getY() == 1) ||
                (squareToAttack.getX() - currentSquare.getX() == -2 &&
                    squareToAttack.getY() - currentSquare.getY() == -1)
            ) &&
            squareToAttack.getPiece() != null &&
            squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {

        }
    };

    public default void moveBishop(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
        if (
            (
                squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                squareToMoveTo.getY() - currentSquare.getY() != 0 &&
                squareToMoveTo.getX() - currentSquare.getX() == squareToMoveTo.getY() - currentSquare.getY()
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToMoveTo.setPiece(currentSquare.getPiece());
                currentSquare.setPiece(null);
            }
        }
    };

    public default void attackWithBishop(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
                (
                    squareToAttack.getX() - currentSquare.getX() != 0 &&
                    squareToAttack.getY() - currentSquare.getY() != 0 &&
                    squareToAttack.getX() - currentSquare.getX() == squareToAttack.getY() - currentSquare.getY()
                ) &&
                squareToAttack.getPiece() != null &&
                squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {

            }
        }
    };

    public default void moveRook(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() != 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0)
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToMoveTo.setPiece(currentSquare.getPiece());
                currentSquare.setPiece(null);
            }
        }
    };

    public default void attackWithRook(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
                (
                    (squareToAttack.getX() - currentSquare.getX() == 0 &&
                        squareToAttack.getY() - currentSquare.getY() != 0) ||
                    (squareToAttack.getX() - currentSquare.getX() != 0 &&
                        squareToAttack.getY() - currentSquare.getY() == 0)
                ) &&
                squareToAttack.getPiece() != null &&
                squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {

            }
        }
    };

    public default void moveQueen(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
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
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToMoveTo.setPiece(currentSquare.getPiece());
                currentSquare.setPiece(null);
            }
        }
    };

    public default void attackWithQueen(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
            (
                (squareToAttack.getX() - currentSquare.getX() == 0 &&
                    squareToAttack.getY() - currentSquare.getY() != 0) ||
                (squareToAttack.getX() - currentSquare.getX() != 0 &&
                    squareToAttack.getY() - currentSquare.getY() == 0) ||
                (
                    squareToAttack.getX() - currentSquare.getX() != 0 &&
                    squareToAttack.getY() - currentSquare.getY() != 0 &&
                    squareToAttack.getX() - currentSquare.getX() == squareToAttack.getY() - currentSquare.getY()
                )
            ) &&
            squareToAttack.getPiece() != null &&
            squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {

            }
        }
    };

    public default void moveKing(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
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
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToMoveTo.setPiece(currentSquare.getPiece());
                currentSquare.setPiece(null);
            }
        }
    };

    public default void attackWithKing(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (
                (
                    (squareToAttack.getX() - currentSquare.getX() == 1 &&
                        squareToAttack.getY() - currentSquare.getY() == 0) ||
                    (squareToAttack.getX() - currentSquare.getX() == 1 &&
                        squareToAttack.getY() - currentSquare.getY() == -1) ||
                    (squareToAttack.getX() - currentSquare.getX() == 0 &&
                        squareToAttack.getY() - currentSquare.getY() == -1) ||
                    (squareToAttack.getX() - currentSquare.getX() == -1 &&
                        squareToAttack.getY() - currentSquare.getY() == -1) ||
                    (squareToAttack.getX() - currentSquare.getX() == -1 &&
                        squareToAttack.getY() - currentSquare.getY() == 0) ||
                    (squareToAttack.getX() - currentSquare.getX() == -1 &&
                        squareToAttack.getY() - currentSquare.getY() == 1) ||
                    (squareToAttack.getX() - currentSquare.getX() == 0 &&
                        squareToAttack.getY() - currentSquare.getY() == 1) ||
                    (squareToAttack.getX() - currentSquare.getX() == 1 &&
                        squareToAttack.getY() - currentSquare.getY() == 1)
                ) &&
                squareToAttack.getPiece() != null &&
                squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {

            }
        }
    };
}
