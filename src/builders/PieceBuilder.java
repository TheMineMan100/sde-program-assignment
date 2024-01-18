package builders;

import allegiances.Allegiance;
import pieces.Piece;
import states.PieceState;

public interface PieceBuilder {
    void reset();

    void setAllegiance(Allegiance allegiance);

    void setState(PieceState state);

    void setHealth(double health);

    void setArmor(int armor);

    void setDamage(double damage);

    void setSymbol(String symbol);

    Piece getResult();
}
