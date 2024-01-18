package factories;

import allegiances.Allegiance;
import builders.BishopPieceBuilder;
import pieces.BishopPiece;
import states.HealthyState;
import states.NullState;

public class BishopPieceFactory implements PieceFactory<BishopPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private BishopPieceBuilder newBuilder;

    public BishopPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    }

    @Override
    public BishopPiece createWhitePiece(BishopPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState(new NullState());
        builder.setHealth(3);
        builder.setArmor(0);
        builder.setDamage(2);

        BishopPiece bishop = builder.getResult();
        bishop.changeState(new HealthyState(bishop));

        return bishop;
    };

    @Override
    public BishopPiece createBlackPiece(BishopPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState(new NullState());
        builder.setHealth(3);
        builder.setArmor(0);
        builder.setDamage(2);

        BishopPiece bishop = builder.getResult();
        bishop.changeState(new HealthyState(bishop));

        return bishop;
    };
}
