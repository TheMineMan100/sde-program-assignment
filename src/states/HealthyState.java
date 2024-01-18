package states;

import board.Square;
import pieces.Piece;

public class HealthyState implements PieceState {
    private final Piece context;

    public HealthyState(Piece context) {
        this.context = context;
    }

    @Override
    public void changeState(PieceState newState) {
        this.context.changeState(newState);
    }

    @Override
    public void updateDuration() {

    }

    @Override
    public void applyEffect() {

    }
}