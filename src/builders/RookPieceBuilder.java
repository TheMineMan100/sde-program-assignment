package builders;

import builders.PieceBuilder;
import pieces.RookPiece;

public class RookPieceBuilder implements PieceBuilder {
    private RookPiece rook = new RookPiece();

    @Override
    public void reset() {
        this.rook = new RookPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.rook.setAllegiance(isWhite);
    }

    @Override
    public void setHealth(int health) {
        this.rook.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.rook.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.rook.setDamage(damage);
    }
}
