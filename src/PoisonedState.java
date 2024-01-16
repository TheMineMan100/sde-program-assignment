public class PoisonedState implements StatusEffectState {
    public Piece context;

    public PoisonedState(Piece context) {
        this.context = context;
    }

    @Override
    public void updateDuration() {

    };

    @Override
    public void removeEffect() {

    };

    @Override
    public void applyEffect() {

    };
}
