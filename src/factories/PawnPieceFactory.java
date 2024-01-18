package factories;

import allegiances.Allegiance;
import builders.PawnPieceBuilder;
import pieces.PawnPiece;
import states.HealthyState;

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
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        PawnPiece pawn = builder.getResult();
        pawn.setState(new HealthyState(pawn));
        return pawn;
    };

    @Override
    public PawnPiece createBlackPiece(PawnPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        PawnPiece pawn = builder.getResult();
        pawn.setState(new HealthyState(pawn));
        return pawn;
    };
}
