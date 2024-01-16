public class BishopPieceBuilder implements PieceBuilder{
    private BishopPiece bishop = new BishopPiece();

    @Override
    public void reset() {
        this.bishop = new BishopPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.bishop.setAllegiance(isWhite);
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.bishop.setPosition(posX, posY);
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
}
