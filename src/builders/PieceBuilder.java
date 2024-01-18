package builders;

public interface PieceBuilder {
    void reset();

    void setAllegiance(Boolean isWhite);

    void setHealth(int health);

    void setArmor(int armor);

    void setDamage(int damage);
}
