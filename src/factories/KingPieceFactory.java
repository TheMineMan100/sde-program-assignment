package factories;

import allegiances.Allegiance;
import builders.KingPieceBuilder;
import pieces.KingPiece;
import states.HealthyState;
import states.NullState;

public class KingPieceFactory implements PieceFactory<KingPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public KingPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public KingPiece createWhitePiece(KingPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState(new NullState());
        builder.setHealth(5);
        builder.setArmor(2);
        builder.setDamage(4);

        KingPiece king = builder.getResult();
        king.changeState(new HealthyState(king));

        return king;
    };

    @Override
    public KingPiece createBlackPiece(KingPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState(new NullState());
        builder.setHealth(5);
        builder.setArmor(2);
        builder.setDamage(3);

        KingPiece king = builder.getResult();
        king.changeState(new HealthyState(king));

        return king;
    };
}
