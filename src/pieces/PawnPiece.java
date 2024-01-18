package pieces;

import board.Square;
import allegiances.Allegiance;
import states.PieceState;

public class PawnPiece implements Piece {

    private Allegiance allegiance;

    private PieceState state;

    private int health;

    private int armor;

    private int damage;

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public void setState(PieceState state) {
        this.state = state;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

//    private boolean canMoveToSquare(Square currentSquare, Square squareToMoveTo) {
//        if(isWhite) {
//            if (
//                squareToMoveTo.getX() - currentSquare.getX() == 0 &&
//                squareToMoveTo.getY() - currentSquare.getY() == 1 &&
//                squareToMoveTo.getPiece() == null
//            ) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        if (
//            squareToMoveTo.getX() - currentSquare.getX() == 0 &&
//            squareToMoveTo.getY() - currentSquare.getY() == -1 &&
//            squareToMoveTo.getPiece() == null
//        ) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public void move(Square currentSquare, Square squareToMoveTo) {
        this.allegiance.movePawn(currentSquare, squareToMoveTo);
    }

    @Override
    public void attack() {

    };

    @Override
    public void specialAction() {

    };
}
