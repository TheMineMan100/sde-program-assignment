package pieces;

import allegiances.Allegiance;
import board.Square;
import states.PieceState;

public class KnightPiece implements Piece {
    private Allegiance allegiance;

    private PieceState state;

    private double health;

    private int armor;

    private double damage;

    private Boolean canMove;

    private Boolean canAttack;

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public Allegiance getAllegiance() {
        return this.allegiance;
    }

    @Override
    public void changeState(PieceState state) {
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
    public void setCanMove(Boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public void setCanAttack(Boolean canAttack) {
        this.canAttack = canAttack;
    }

    @Override
    public void multiplyDamage(double multiplier) {
        this.damage *= multiplier;
    }

    @Override
    public void move(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween) {
        if (canMove) {
            this.allegiance.moveKnight(currentSquare, squareToMoveTo, squaresInBetween);
        }
    }

    @Override
    public void attack(Square currentSquare, Square squareToAttack, Square[] squaresInBetween) {
        if (canAttack) {
            this.allegiance.attackWithKnight(currentSquare, squareToAttack, squaresInBetween);
        }
    }

    @Override
    public void specialAction() {

    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public void gainHealth(double health) {
        this.health += health;
    }
}
