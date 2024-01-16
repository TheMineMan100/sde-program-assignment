public class KingPieceBuilder implements PieceBuilder{
    private KingPiece king = new KingPiece();

    @Override
    public void reset() {
        this.king = new KingPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.king.setAllegiance(isWhite);
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.king.setPosition(posX, posY);
    }

    @Override
    public void setHealth(int health) {
        this.king.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.king.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.king.setDamage(damage);
    }
}
