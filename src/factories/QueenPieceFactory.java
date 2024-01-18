package factories;

import allegiances.Allegiance;
import builders.QueenPieceBuilder;
import pieces.QueenPiece;
import states.HealthyState;
import states.NullState;

public class QueenPieceFactory implements PieceFactory<QueenPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private QueenPieceBuilder builder;

    public QueenPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
        this.builder = new QueenPieceBuilder();
    };

    @Override
    public QueenPiece createWhitePiece() {
        this.builder.setAllegiance(this.whiteAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(4);
        this.builder.setArmor(3);
        this.builder.setDamage(6);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♕");

        QueenPiece queen = this.builder.getResult();
        queen.changeState(new HealthyState(queen));

        return queen;
    };

    @Override
    public QueenPiece createBlackPiece() {
        this.builder.setAllegiance(this.blackAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(4);
        this.builder.setArmor(3);
        this.builder.setDamage(6);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♛");

        QueenPiece queen = this.builder.getResult();
        queen.changeState(new HealthyState(queen));

        return queen;
    };
}
