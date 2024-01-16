public class FootSoldierPieceBuilder implements PieceBuilder{
    private FootSoldierPiece footSoldier = new FootSoldierPiece();

    @Override
    public void reset() {
        this.footSoldier = new FootSoldierPiece();
    }

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.footSoldier.setAllegiance(isWhite);
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.footSoldier.setPosition(posX, posY);
    }

    @Override
    public void setHealth(int health) {
        this.footSoldier.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.footSoldier.setArmor(armor);
    }

    @Override
    public void setDamage(int damage) {
        this.footSoldier.setDamage(damage);
    }
}
