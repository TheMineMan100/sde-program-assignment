package factories;

import allegiances.Allegiance;
import builders.PawnPieceBuilder;
import pieces.PawnPiece;
import states.HealthyState;
import states.NullState;

public class PawnPieceFactory implements PieceFactory<PawnPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private PawnPieceBuilder builder;

    public PawnPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
        this.builder = new PawnPieceBuilder();
    };

    @Override
    public PawnPiece createWhitePiece() {
        this.builder.setAllegiance(this.whiteAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(1);
        this.builder.setArmor(0);
        this.builder.setDamage(1);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♙");

        PawnPiece pawn = this.builder.getResult();
        pawn.changeState(new HealthyState(pawn));

        return pawn;
    };

    @Override
    public PawnPiece createBlackPiece() {
        this.builder.setAllegiance(this.blackAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(1);
        this.builder.setArmor(0);
        this.builder.setDamage(1);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♟");

        PawnPiece pawn = this.builder.getResult();
        pawn.changeState(new HealthyState(pawn));

        return pawn;
    };
}
