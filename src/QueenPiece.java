public class QueenPiece implements Piece{
    private Boolean isWhite;

    private int posX;

    private int posY;

    private int health;

    private int armor;

    private int damage;

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
