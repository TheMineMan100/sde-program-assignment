public class QueenPieceBuilder implements PieceBuilder{
    private QueenPiece queen = new QueenPiece();

    @Override
    public void reset() {
        this.queen = new QueenPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.queen.setAllegiance(isWhite);
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.queen.setPosition(posX, posY);
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
}
