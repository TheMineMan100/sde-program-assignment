package builders;

import allegiances.Allegiance;
import allegiances.White;
import pieces.BishopPiece;
import states.PieceState;

public class BishopPieceBuilder implements PieceBuilder {
    private BishopPiece bishop = new BishopPiece();

    @Override
    public void reset() {
        this.bishop = new BishopPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.bishop.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.bishop.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.bishop.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.bishop.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.bishop.setDamage(damage);
    }

    @Override
    public void setSymbol(String symbol) {
        this.bishop.setSymbol(symbol);
    }

    public BishopPiece getResult() {
        BishopPiece result = this.bishop;
        this.reset();
        return result;
    }
}
