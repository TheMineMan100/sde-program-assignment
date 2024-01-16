package states;

import pieces.Piece;
import states.PieceState;

public class PoisonedState implements PieceState {
    private Piece context;

    public PoisonedState(Piece context) {
        this.context = context;
    }

    @Override
    public boolean isAlive() {
        return true;
    };

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
