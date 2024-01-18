package factories;

import allegiances.Allegiance;
import builders.KingPieceBuilder;
import pieces.KingPiece;
import states.HealthyState;

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
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        KingPiece king = builder.getResult();
        king.setState(new HealthyState(king));
        return king;
    };

    @Override
    public KingPiece createBlackPiece(KingPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        KingPiece king = builder.getResult();
        king.setState(new HealthyState(king));
        return king;
    };
}
