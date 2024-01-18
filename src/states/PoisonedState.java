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
    public void changeState() {
        context.changeState(new HealthyState(context));
    }

    @Override
    public void updateDuration() {
        this.durationLeft--;
    }

    @Override
    public void applyEffect() {
        this.updateDuration();

        if (! poisonHasBeenApplied) {
            this.context.multiplyDamage(poisonWeaknessMultiplier);
        }

        if (this.durationLeft <= 0) {
            this.changeState();
        }
    }
}
