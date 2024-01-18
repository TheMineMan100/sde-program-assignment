package pieces;

import board.Square;

public class KnightPiece implements Piece {
    private Boolean isWhite;

    private int health;

    private int armor;

    private int damage;

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.isWhite = isWhite;
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

    private boolean canMoveToSquare(Square currentSquare, Square squareToMoveTo) {
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
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(Square currentSquare, Square squareToMoveTo) {
        if (canMoveToSquare(currentSquare, squareToMoveTo)) {
            squareToMoveTo.setPiece(this);
            currentSquare.setPiece(null);
        }
    }

    @Override
    public void attack() {

    };

    @Override
    public void specialAction() {

    };
}
