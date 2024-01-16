public class HealthyState implements PieceState {
    private Piece context;

    public HealthyState(Piece context) {
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