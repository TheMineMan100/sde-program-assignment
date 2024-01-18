package builders;

import pieces.KnightPiece;

public class KnightPieceBuilder implements PieceBuilder {
    private KnightPiece knight = new KnightPiece();

    @Override
    public void reset() {
        this.knight = new KnightPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.knight.setAllegiance(isWhite);
    }

    @Override
    public void setHealth(int health) {
        this.knight.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.knight.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.knight.setDamage(damage);
    }
}
