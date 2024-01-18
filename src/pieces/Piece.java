package pieces;

import allegiances.Allegiance;
import board.Square;
import states.PieceState;

public interface Piece {
    public void setAllegiance(Allegiance allegiance);

    public void setState(PieceState state);

    public void setHealth(int health);

    public void setArmor(int armor);

    public void setDamage(int damage);

    public void move(Square currentSquare, Square squareToMoveTo, Square[] squaresInBetween);

    public void attack(Square currentSquare, Square squareToAttack, Square[] squaresInBetween);

    public void specialAction();
}
