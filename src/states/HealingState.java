package states;

import board.Square;
import pieces.Piece;

public class HealingState implements PieceState {
    private final Piece context;

    private int durationLeft;

    private final double healAmount;

    public HealingState(Piece context, int duration) {
        this.context = context;
        this.durationLeft = duration;
        this.healAmount = 1;
    }

    @Override
    public void changeState(PieceState newState) {
        context.changeState(newState);
    }

    @Override
    public void updateDuration() {
        this.durationLeft--;
    }

    @Override
    public void applyEffect() {
        if (this.durationLeft > 0) {
            this.context.gainHealth(healAmount);
        }

        this.updateDuration();

        if (this.durationLeft <= 0) {
            this.changeState(new HealthyState(context));
        }
    }
}
