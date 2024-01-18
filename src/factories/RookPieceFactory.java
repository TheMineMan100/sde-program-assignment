package factories;

import allegiances.Allegiance;
import builders.RookPieceBuilder;
import pieces.RookPiece;
import states.HealthyState;

public class RookPieceFactory implements PieceFactory<RookPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public RookPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public RookPiece createWhitePiece(RookPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        RookPiece rook = builder.getResult();
        rook.setState(new HealthyState(rook));
        return rook;
    };

    @Override
    public RookPiece createBlackPiece(RookPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        RookPiece rook = builder.getResult();
        rook.setState(new HealthyState(rook));
        return rook;
    };
}
