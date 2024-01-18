package states;

import board.Square;
import pieces.Piece;

public class StunnedState implements PieceState {
    private final Piece context;

    private int durationLeft;

    public StunnedState(Piece context, int duration) {
        this.context = context;
        this.durationLeft = duration;
    }

    @Override
    public void changeState(PieceState newState) {
        this.context.setCanMove(true);
        this.context.setCanAttack(true);

        context.changeState(newState);
    }

    @Override
    public void updateDuration() {
        this.durationLeft--;
    }

    @Override
    public void applyEffect() {
        if (this.durationLeft > 0) {
            this.context.setCanMove(false);
            this.context.setCanAttack(false);
        }

        this.updateDuration();

        if (this.durationLeft <= 0) {
            this.changeState(new HealthyState(context));
        }
    }
}
