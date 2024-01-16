package pieces;

public interface Piece {
    void setAllegiance(Boolean isWhite);

    void setHealth(int health);

    void setArmor(int armor);

    void setDamage(int damage);

    void move();
}
