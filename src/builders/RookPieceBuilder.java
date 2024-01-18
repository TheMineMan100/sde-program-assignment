package builders;

import allegiances.Allegiance;
import pieces.RookPiece;
import states.PieceState;

public class RookPieceBuilder implements PieceBuilder {
    private RookPiece rook = new RookPiece();

    @Override
    public void reset() {
        this.rook = new RookPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.rook.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.rook.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.rook.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.rook.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.rook.setDamage(damage);
    }

    public RookPiece getResult() {
        RookPiece result = this.rook;
        this.reset();
        return result;
    }
}
