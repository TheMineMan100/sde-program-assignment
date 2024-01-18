package states;

import pieces.Piece;

public class HealingState implements PieceState {
    private Piece context;

    private int durationLeft;

    private final double healAmount;

    public HealingState(Piece context, int duration) {
        this.context = context;
        this.durationLeft = duration;
        this.healAmount = 1;
    }

    @Override
    public void changeState() {
        context.changeState(new HealthyState(context));
    };

    @Override
    public void updateDuration() {
        this.durationLeft--;
    };

    @Override
    public void applyEffect() {
        this.updateDuration();

        this.context.gainHealth(healAmount);

        if (this.durationLeft <= 0) {
            this.changeState();
        }
    };
}
