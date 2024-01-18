package pieces;

import allegiances.Allegiance;
import board.Square;
import states.PieceState;

public class BishopPiece implements Piece {
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
    public Allegiance getAllegiance() {
        return this.allegiance;
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

    @Override
    public void move(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
        this.allegiance.moveBishop(currentSquare, squareToMoveTo, squaresInBetween);
    }

    @Override
    public void attack(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        this.allegiance.attackWithBishop(currentSquare, squareToAttack, squaresInBetween);
    };

    @Override
    public void specialAction() {

    };
}
