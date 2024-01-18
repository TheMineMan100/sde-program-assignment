package factories;

import allegiances.Allegiance;
import builders.KnightPieceBuilder;
import pieces.KnightPiece;
import states.HealthyState;
import states.NullState;

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
        builder.setState(new NullState());
        builder.setHealth(3);
        builder.setArmor(1);
        builder.setDamage(3);

        KnightPiece knight = builder.getResult();
        knight.changeState(new HealthyState(knight));

        return knight;
    };

    @Override
    public KnightPiece createBlackPiece(KnightPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState(new NullState());
        builder.setHealth(3);
        builder.setArmor(1);
        builder.setDamage(3);

        KnightPiece knight = builder.getResult();
        knight.changeState(new HealthyState(knight));

        return knight;
    };
}
