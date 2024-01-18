package allegiances;

import board.Square;
import states.HealingState;
import states.PoisonedState;
import states.StunnedState;

public interface Allegiance {
    public void movePawn(Square currentSquare, Square squareToMoveTo, Square[][] squares);

    public void attackWithPawn(Square currentSquare, Square squareToMoveTo, Square[][] squares);

    public default void moveKnight(Square currentSquare, Square squareToMoveTo, Square[][] squares) {
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

    public default void attackWithKnight(Square currentSquare, Square squareToAttack, Square[][] squares) {
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
            squareToAttack.getPiece().takeDamage(currentSquare.getPiece().getDamage());
        }
    };

    public default void specialActionWithKnight(Square currentSquare, Square squareToAffect, Square[][] squares) {
        if (
            (
                (squareToAffect.getX() - currentSquare.getX() == 1 &&
                    squareToAffect.getY() - currentSquare.getY() == 2) ||
                (squareToAffect.getX() - currentSquare.getX() == 1 &&
                    squareToAffect.getY() - currentSquare.getY() == -2) ||
                (squareToAffect.getX() - currentSquare.getX() == 2 &&
                    squareToAffect.getY() - currentSquare.getY() == 1) ||
                (squareToAffect.getX() - currentSquare.getX() == 2 &&
                    squareToAffect.getY() - currentSquare.getY() == -1) ||
                (squareToAffect.getX() - currentSquare.getX() == -1 &&
                    squareToAffect.getY() - currentSquare.getY() == 2) ||
                (squareToAffect.getX() - currentSquare.getX() == -1 &&
                    squareToAffect.getY() - currentSquare.getY() == -2) ||
                (squareToAffect.getX() - currentSquare.getX() == -2 &&
                    squareToAffect.getY() - currentSquare.getY() == 1) ||
                (squareToAffect.getX() - currentSquare.getX() == -2 &&
                    squareToAffect.getY() - currentSquare.getY() == -1)
            ) &&
            squareToAffect.getPiece() != null &&
            squareToAffect.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            squareToAffect.getPiece().changeState(new PoisonedState(squareToAffect.getPiece(), 3));
        }
    };

    public default void moveBishop(Square currentSquare, Square squareToMoveTo, Square[][] squares) {
        if (
            (
                squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                squareToMoveTo.getY() - currentSquare.getY() != 0 &&
                squareToMoveTo.getX() - currentSquare.getX() == squareToMoveTo.getY() - currentSquare.getY()
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToMoveTo.getX();
            int squareToMoveToYCoordinate = squareToMoveTo.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 2,2 3,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            } else if (currentSquareXCoordinate > squareToMoveToXCoordinate) { // 4 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 3,2 2,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            }

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

    public default void attackWithBishop(Square currentSquare, Square squareToAttack, Square[][] squares) {
        if (
                (
                    squareToAttack.getX() - currentSquare.getX() != 0 &&
                    squareToAttack.getY() - currentSquare.getY() != 0 &&
                    squareToAttack.getX() - currentSquare.getX() == squareToAttack.getY() - currentSquare.getY()
                ) &&
                squareToAttack.getPiece() != null &&
                squareToAttack.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToAttack.getX();
            int squareToMoveToYCoordinate = squareToAttack.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 2,2 3,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            } else if (currentSquareXCoordinate > squareToMoveToXCoordinate) { // 4 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 3,2 2,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            }

            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToAttack.getPiece().takeDamage(currentSquare.getPiece().getDamage());
            }
        }
    };

    public default void specialActionWithBishop(Square currentSquare, Square squareToAffect, Square[][] squares) {
        if (
            (
                squareToAffect.getX() - currentSquare.getX() != 0 &&
                squareToAffect.getY() - currentSquare.getY() != 0 &&
                squareToAffect.getX() - currentSquare.getX() == squareToAffect.getY() - currentSquare.getY()
            ) &&
            squareToAffect.getPiece() != null &&
            squareToAffect.getPiece().getAllegiance() == currentSquare.getPiece().getAllegiance()
        ) {
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToAffect.getX();
            int squareToMoveToYCoordinate = squareToAffect.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 2,2 3,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            } else if (currentSquareXCoordinate > squareToMoveToXCoordinate) { // 4 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                } else { // 3 vs 0  Er moet: 3,2 2,1
                    int amountOfLoops = 0;
                    int YToAdd = 1;
                    for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                        squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                        amountOfLoops += 1;
                        YToAdd += 1;
                    }
                }
            }

            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToAffect.getPiece().changeState(new HealingState(squareToAffect.getPiece(), 3));
            }
        }
    };

    public default void moveRook(Square currentSquare, Square squareToMoveTo, Square[][] squares) {
        if (
            (
                (squareToMoveTo.getX() - currentSquare.getX() == 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() != 0) ||
                (squareToMoveTo.getX() - currentSquare.getX() != 0 &&
                    squareToMoveTo.getY() - currentSquare.getY() == 0)
            ) &&
            squareToMoveTo.getPiece() == null
        ) {
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToMoveTo.getX();
            int squareToMoveToYCoordinate = squareToMoveTo.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate == squareToMoveToXCoordinate) { // 1 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 1 vs 4 Er moet: 1,2 1,3
                    int amountOfLoops = 0;
                    for (int i = currentSquareYCoordinate + 1; i < squareToMoveToYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                } else { // 4 vs 1 Er moet: 1,3 1,2
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToYCoordinate + 1; i < currentSquareYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                }
            } else { // 1 vs 4 & 4 vs 1
                if (currentSquareYCoordinate == squareToMoveToYCoordinate) { // 1 vs 1 Er moet 2,1 & 3,1
                    if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                        int amountOfLoops = 0;
                        for (int i = currentSquareXCoordinate + 1; i < squareToMoveToXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                        }
                    } else { // 4 vs 1
                        int amountOfLoops = 0;
                        for (int i = squareToMoveToXCoordinate + 1; i < currentSquareXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                        }
                    }
                } else {
                    squaresInBetween = null;
                }
            }

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

    public default void attackWithRook(Square currentSquare, Square squareToAttack, Square[][] squares) {
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
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToAttack.getX();
            int squareToMoveToYCoordinate = squareToAttack.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate == squareToMoveToXCoordinate) { // 1 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 1 vs 4 Er moet: 1,2 1,3
                    int amountOfLoops = 0;
                    for (int i = currentSquareYCoordinate + 1; i < squareToMoveToYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                } else { // 4 vs 1 Er moet: 1,3 1,2
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToYCoordinate + 1; i < currentSquareYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                }
            } else { // 1 vs 4 & 4 vs 1
                if (currentSquareYCoordinate == squareToMoveToYCoordinate) { // 1 vs 1 Er moet 2,1 & 3,1
                    if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                        int amountOfLoops = 0;
                        for (int i = currentSquareXCoordinate + 1; i < squareToMoveToXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                        }
                    } else { // 4 vs 1
                        int amountOfLoops = 0;
                        for (int i = squareToMoveToXCoordinate + 1; i < currentSquareXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                        }
                    }
                } else {
                    squaresInBetween = null;
                }
            }

            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToAttack.getPiece().takeDamage(currentSquare.getPiece().getDamage());
            }
        }
    };

    public default void moveQueen(Square currentSquare, Square squareToMoveTo, Square[][] squares) {
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
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToMoveTo.getX();
            int squareToMoveToYCoordinate = squareToMoveTo.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate == squareToMoveToXCoordinate) { // 1 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 1 vs 4 Er moet: 1,2 1,3
                    int amountOfLoops = 0;
                    for (int i = currentSquareYCoordinate + 1; i < squareToMoveToYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                } else { // 4 vs 1 Er moet: 1,3 1,2
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToYCoordinate + 1; i < currentSquareYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                }
            } else if (currentSquareYCoordinate == squareToMoveToYCoordinate) { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 1 vs 1 ;Er moet 2,1 & 3,1
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    int amountOfLoops = 0;
                    for (int i = currentSquareXCoordinate + 1; i < squareToMoveToXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                } else { // 4 vs 1
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToXCoordinate + 1; i < currentSquareXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                }
            } else { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 0 vs 3 & 3 vs 0
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 2,2 3,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                } else { // 4 vs 1
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 3,2 2,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                }
            }

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

    public default void attackWithQueen(Square currentSquare, Square squareToAttack, Square[][] squares) {
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
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToAttack.getX();
            int squareToMoveToYCoordinate = squareToAttack.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate == squareToMoveToXCoordinate) { // 1 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 1 vs 4 Er moet: 1,2 1,3
                    int amountOfLoops = 0;
                    for (int i = currentSquareYCoordinate + 1; i < squareToMoveToYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                } else { // 4 vs 1 Er moet: 1,3 1,2
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToYCoordinate + 1; i < currentSquareYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                }
            } else if (currentSquareYCoordinate == squareToMoveToYCoordinate) { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 1 vs 1 ;Er moet 2,1 & 3,1
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    int amountOfLoops = 0;
                    for (int i = currentSquareXCoordinate + 1; i < squareToMoveToXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                } else { // 4 vs 1
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToXCoordinate + 1; i < currentSquareXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                }
            } else { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 0 vs 3 & 3 vs 0
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 2,2 3,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                } else { // 4 vs 1
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 3,2 2,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                }
            }

            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToAttack.getPiece().takeDamage(currentSquare.getPiece().getDamage());
            }
        }
    };

    public default void specialActionWithQueen(Square currentSquare, Square squareToAffect, Square[][] squares) {
        if (
            (
                (squareToAffect.getX() - currentSquare.getX() == 0 &&
                    squareToAffect.getY() - currentSquare.getY() != 0) ||
                (squareToAffect.getX() - currentSquare.getX() != 0 &&
                    squareToAffect.getY() - currentSquare.getY() == 0) ||
                (
                    squareToAffect.getX() - currentSquare.getX() != 0 &&
                    squareToAffect.getY() - currentSquare.getY() != 0 &&
                    squareToAffect.getX() - currentSquare.getX() == squareToAffect.getY() - currentSquare.getY()
                )
            ) &&
            squareToAffect.getPiece() != null &&
            squareToAffect.getPiece().getAllegiance() != currentSquare.getPiece().getAllegiance()
        ) {
            int currentSquareXCoordinate = currentSquare.getX();
            int currentSquareYCoordinate = currentSquare.getY();

            int squareToMoveToXCoordinate = squareToAffect.getX();
            int squareToMoveToYCoordinate = squareToAffect.getY();

            Square[] squaresInBetween = {};

            if (currentSquareXCoordinate == squareToMoveToXCoordinate) { // 1 vs 1
                if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 1 vs 4 Er moet: 1,2 1,3
                    int amountOfLoops = 0;
                    for (int i = currentSquareYCoordinate + 1; i < squareToMoveToYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                } else { // 4 vs 1 Er moet: 1,3 1,2
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToYCoordinate + 1; i < currentSquareYCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[currentSquareXCoordinate][i]; // 1,2 & 1,3 klopt
                    }
                }
            } else if (currentSquareYCoordinate == squareToMoveToYCoordinate) { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 1 vs 1 ;Er moet 2,1 & 3,1
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    int amountOfLoops = 0;
                    for (int i = currentSquareXCoordinate + 1; i < squareToMoveToXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                } else { // 4 vs 1
                    int amountOfLoops = 0;
                    for (int i = squareToMoveToXCoordinate + 1; i < currentSquareXCoordinate; i++) { // 2 vs 4 & 3 vs 4
                        squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate]; // 2,1 & 3,1 klopt
                    }
                }
            } else { // X-coordinaten: 1 vs 4 & 4 vs 1 ;Y-coordinaten: 0 vs 3 & 3 vs 0
                if (currentSquareXCoordinate < squareToMoveToXCoordinate) { // 1 vs 4
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 2,1 3,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 2,2 3,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = currentSquareXCoordinate + 1; i <= squareToMoveToXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][currentSquareYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                } else { // 4 vs 1
                    if (currentSquareYCoordinate < squareToMoveToYCoordinate) { // 0 vs 3  Er moet: 3,1 2,2
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate - YToAdd]; // 2  &  1,  2,2 en 3,1 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    } else { // 3 vs 0  Er moet: 3,2 2,1
                        int amountOfLoops = 0;
                        int YToAdd = 1;
                        for (int i = squareToMoveToXCoordinate + 1; i <= currentSquareXCoordinate - 1; i++) { // 2 vs 3 & 3 vs 3
                            squaresInBetween[amountOfLoops] = squares[i][squareToMoveToYCoordinate + YToAdd]; // 1  &  2,  2,1 en 3,2 klopt
                            amountOfLoops += 1;
                            YToAdd += 1;
                        }
                    }
                }
            }

            boolean noPiecesInBetween = true;
            for (int i = 0; i < squaresInBetween.length; i++) {
                if (squaresInBetween[i].getPiece() != null) {
                    noPiecesInBetween = false;
                    break;
                }
            }
            if (noPiecesInBetween) {
                squareToAffect.getPiece().changeState(new StunnedState(squareToAffect.getPiece(), 1));
            }
        }
    };

    public default void moveKing(Square currentSquare, Square squareToMoveTo, Square[][] squares) {
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

    public default void attackWithKing(Square currentSquare, Square squareToAttack, Square[][] squares) {
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
            squareToAttack.getPiece().takeDamage(currentSquare.getPiece().getDamage());
        }
    };
}
