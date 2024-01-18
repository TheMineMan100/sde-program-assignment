package builders;

import allegiances.Allegiance;
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
        this.bishop.setState(state);
    }

    @Override
    public void setHealth(int health) {
        this.bishop.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.bishop.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.bishop.setDamage(damage);
    }

    public BishopPiece getResult() {
        BishopPiece result = this.bishop;
        this.reset();
        return result;
    }
}
