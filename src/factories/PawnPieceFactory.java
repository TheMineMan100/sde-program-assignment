package factories;

import allegiances.Allegiance;
import builders.PawnPieceBuilder;
import pieces.PawnPiece;
import states.HealthyState;
import states.NullState;

public class PawnPieceFactory implements PieceFactory<PawnPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public PawnPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public PawnPiece createWhitePiece(PawnPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState(new NullState());
        builder.setHealth(1);
        builder.setArmor(0);
        builder.setDamage(1);

        PawnPiece pawn = builder.getResult();
        pawn.changeState(new HealthyState(pawn));

        return pawn;
    };

    @Override
    public PawnPiece createBlackPiece(PawnPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState(new NullState());
        builder.setHealth(1);
        builder.setArmor(0);
        builder.setDamage(1);

        PawnPiece pawn = builder.getResult();
        pawn.changeState(new HealthyState(pawn));

        return pawn;
    };
}
