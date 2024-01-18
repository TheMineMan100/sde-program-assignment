package builders;

import allegiances.Allegiance;
import pieces.KnightPiece;
import states.PieceState;

public class KnightPieceBuilder implements PieceBuilder {
    private KnightPiece knight = new KnightPiece();

    @Override
    public void reset() {
        this.knight = new KnightPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.knight.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.knight.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.knight.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.knight.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.knight.setDamage(damage);
    }

    @Override
    public void setSymbol(String symbol) {
        this.knight.setSymbol(symbol);
    }

    public KnightPiece getResult() {
        KnightPiece result = this.knight;
        this.reset();
        return result;
    }
}
