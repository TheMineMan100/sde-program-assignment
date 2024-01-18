package factories;

import allegiances.Allegiance;
import builders.QueenPieceBuilder;
import pieces.QueenPiece;
import states.HealthyState;
import states.NullState;

public class QueenPieceFactory implements PieceFactory<QueenPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    public QueenPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
    };

    @Override
    public QueenPiece createWhitePiece(QueenPieceBuilder builder) {
        builder.setAllegiance(this.whiteAllegiance);
        builder.setState(new NullState());
        builder.setHealth(4);
        builder.setArmor(3);
        builder.setDamage(6);

        QueenPiece queen = builder.getResult();
        queen.changeState(new HealthyState(queen));

        return queen;
    };

    @Override
    public QueenPiece createBlackPiece(QueenPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState(new NullState());
        builder.setHealth(4);
        builder.setArmor(3);
        builder.setDamage(6);

        QueenPiece queen = builder.getResult();
        queen.changeState(new HealthyState(queen));

        return queen;
    };
}
