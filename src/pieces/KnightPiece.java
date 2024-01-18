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

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.allegiance = allegiance;
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
    public void multiplyDamage(double multiplier) {
        this.damage *= multiplier;
    }

    @Override
    public void move(Square currentSquare, Square squareToMoveTo) {
        this.allegiance.moveKnight(currentSquare, squareToMoveTo);
    }

    @Override
    public void attack() {

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
