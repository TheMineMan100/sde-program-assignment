package factories;

import allegiances.Allegiance;
import builders.BishopPieceBuilder;
import pieces.BishopPiece;
import states.HealthyState;

public class BishopPieceFactory implements PieceFactory<BishopPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public BishopPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public BishopPiece createWhitePiece(BishopPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        BishopPiece bishop = builder.getResult();
        bishop.setState(new HealthyState(bishop));
        return bishop;
    };

    @Override
    public BishopPiece createBlackPiece(BishopPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        BishopPiece bishop = builder.getResult();
        bishop.setState(new HealthyState(bishop));
        return bishop;
    };
}
