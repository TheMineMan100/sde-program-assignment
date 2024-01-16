public interface PieceState {
    public boolean isAlive();
    public void changeState();
    public void updateDuration();
    public void applyEffect();
}
