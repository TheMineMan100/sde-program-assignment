package builders;

import allegiances.Allegiance;
import pieces.Piece;
import states.PieceState;

public interface PieceBuilder {
    void reset();

    void setAllegiance(Allegiance allegiance);

    void setState(PieceState state);

    void setHealth(int health);

    void setArmor(int armor);

    void setDamage(int damage);

    Piece getResult();
}
