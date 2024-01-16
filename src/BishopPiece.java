public class BishopPiece implements Piece{
    private Boolean isWhite;

    private int health;

    private int armor;

    private int damage;

    @Override
    public void setAllegiance(Boolean isWhite) {
        this.isWhite = isWhite;
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

    @Override
    public void move() {

    }
}
