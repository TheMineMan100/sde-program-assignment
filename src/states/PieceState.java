package states;

import board.Square;

public interface PieceState {
    public void changeState(PieceState newState);

    public void updateDuration();

    public void applyEffect();
}
