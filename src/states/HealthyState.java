package states;

import pieces.Piece;

public class HealthyState implements PieceState {
    private Piece context;

    public HealthyState(Piece context) {
        this.context = context;
    }

    @Override
    public void changeState() {

    };

    @Override
    public void updateDuration() {

    };

    @Override
    public void applyEffect() {

    };
}