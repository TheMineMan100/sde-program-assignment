package builders;

import allegiances.Allegiance;
import pieces.QueenPiece;
import states.PieceState;

public class QueenPieceBuilder implements PieceBuilder {
    private QueenPiece queen = new QueenPiece();

    @Override
    public void reset() {
        this.queen = new QueenPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.queen.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.queen.setState(state);
    }

    @Override
    public void setHealth(int health) {
        this.queen.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.queen.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.queen.setDamage(damage);
    }

    public QueenPiece getResult() {
        QueenPiece result = this.queen;
        this.reset();
        return result;
    }
}
