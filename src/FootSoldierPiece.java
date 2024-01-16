public class FootSoldierPiece {
    private Boolean isWhite;

    private int posX;

    private int posY;

    private int health;

    private int armor;

    private int damage;

    public void setAllegiance(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
