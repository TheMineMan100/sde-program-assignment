package builders;

import allegiances.Allegiance;
import pieces.KingPiece;
import states.PieceState;

public class KingPieceBuilder implements PieceBuilder {
    private KingPiece king = new KingPiece();

    @Override
    public void reset() {
        this.king = new KingPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.king.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.king.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.king.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.king.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.king.setDamage(damage);
    }

    public KingPiece getResult() {
        KingPiece result = this.king;
        this.reset();
        return result;
    }
}
