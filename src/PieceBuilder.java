public interface PieceBuilder {
    void reset();

    void setAllegiance(Boolean isWhite);

    void setPosition(int posX, int posY);

    void setHealth(int health);

    void setArmor(int armor);

    void setDamage(int damage);
}
