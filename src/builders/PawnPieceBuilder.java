package builders;

import pieces.PawnPiece;

public class PawnPieceBuilder implements PieceBuilder {
    private PawnPiece pawn = new PawnPiece();

    @Override
    public void reset() {
        this.pawn = new PawnPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.pawn.setAllegiance(isWhite);
    }

    @Override
    public void setHealth(int health) {
        this.pawn.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.pawn.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.pawn.setDamage(damage);
    }
}
