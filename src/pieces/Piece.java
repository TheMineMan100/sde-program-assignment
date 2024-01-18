package pieces;

import allegiances.Allegiance;
import board.Square;
import states.PieceState;

public interface Piece {
    public void setAllegiance(Allegiance allegiance);

    public Allegiance getAllegiance();

    public void setSymbol(String symbol);

    public void changeState(PieceState state);

    public void setHealth(double health);

    public void setArmor(int armor);

    public void setDamage(double damage);

    public void setCanMove(Boolean canMove);

    public void setCanAttack(Boolean canAttack);

    public String getSymbol();

    public double getDamage();

    public void multiplyDamage(double multiplier);

    public void move(Square currentSquare, Square squareToMoveTo, Square[][] squares);

    public void attack(Square currentSquare, Square squareToAttack, Square[][] squares);

    public void specialAction(Square currentSquare, Square squareToAttack, Square[][] squares);

    public void takeDamage(double damage);

    public void gainHealth(double health);
}
