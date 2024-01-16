package states;

import pieces.Piece;

public class DeadState implements PieceState {
    private Piece context;

    public DeadState(Piece context) {
        this.context = context;
    }

    @Override
    public boolean isAlive() {
        return false;
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
