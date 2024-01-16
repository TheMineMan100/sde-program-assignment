package states;

import pieces.Piece;
import states.PieceState;

public class StunnedState implements PieceState {
    private Piece context;

    public StunnedState(Piece context) {
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
