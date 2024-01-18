package factories;

import allegiances.Allegiance;
import builders.KnightPieceBuilder;
import pieces.KnightPiece;
import states.HealthyState;

public class KnightPieceFactory implements PieceFactory<KnightPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public KnightPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public KnightPiece createWhitePiece(KnightPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        KnightPiece knight = builder.getResult();
        knight.setState(new HealthyState(knight));
        return knight;
    };

    @Override
    public KnightPiece createBlackPiece(KnightPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        KnightPiece knight = builder.getResult();
        knight.setState(new HealthyState(knight));
        return knight;
    };
}
