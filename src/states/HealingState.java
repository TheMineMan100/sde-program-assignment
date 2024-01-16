package states;

import pieces.Piece;

public class HealingState implements PieceState {
    private Piece context;

    public HealingState(Piece context) {
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
