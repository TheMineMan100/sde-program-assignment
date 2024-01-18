package builders;

import allegiances.Allegiance;
import pieces.PawnPiece;
import states.PieceState;

public class PawnPieceBuilder implements PieceBuilder {
    private PawnPiece pawn = new PawnPiece();

    @Override
    public void reset() {
        this.pawn = new PawnPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.pawn.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.pawn.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.pawn.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.pawn.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.pawn.setDamage(damage);
    }

    public PawnPiece getResult() {
        PawnPiece result = this.pawn;
        this.reset();
        return result;
    }
}
