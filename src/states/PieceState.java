package states;

public interface PieceState {
    public void changeState();

    public void updateDuration();

    public void applyEffect();
}
