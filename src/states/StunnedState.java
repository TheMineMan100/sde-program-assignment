package states;

import pieces.Piece;

public class StunnedState implements PieceState {
    private Piece context;

    private int durationLeft;

    public StunnedState(Piece context, int duration) {
        this.context = context;
        this.durationLeft = duration;
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

        if (this.durationLeft <= 0) {
            this.changeState();
        }
    };
}
