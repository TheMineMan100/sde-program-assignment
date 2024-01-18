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
    public void changeState() {
        this.context.setCanMove(true);

        context.changeState(new HealthyState(context));
    }

    @Override
    public void updateDuration() {
        this.durationLeft--;
    }

    @Override
    public void applyEffect() {
        this.updateDuration();

        this.context.setCanMove(false);

        if (this.durationLeft <= 0) {
            this.changeState();
        }
    }
}
