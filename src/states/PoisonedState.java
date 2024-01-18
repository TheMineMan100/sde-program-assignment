package states;

import board.Square;
import pieces.Piece;

public class PoisonedState implements PieceState {
    private final Piece context;

    private int durationLeft;

    private final double poisonWeaknessMultiplier;

    private final Boolean poisonHasBeenApplied;

    public PoisonedState(Piece context, int duration) {
        this.context = context;
        this.durationLeft = duration;
        this.poisonWeaknessMultiplier = 0.5;
        this.poisonHasBeenApplied = false;
    }

    @Override
    public void changeState(PieceState newState) {
        this.context.multiplyDamage(1/poisonWeaknessMultiplier);

        context.changeState(newState);
    }

    @Override
    public void updateDuration() {
        this.durationLeft--;
    }

    @Override
    public void applyEffect() {
        if (this.durationLeft > 0) {
            if (! poisonHasBeenApplied) {
                this.context.multiplyDamage(poisonWeaknessMultiplier);
            }
        }

        this.updateDuration();

        if (this.durationLeft <= 0) {
            this.changeState(new HealthyState(context));
        }
    }
}
