package factories;

import allegiances.Allegiance;
import builders.QueenPieceBuilder;
import pieces.QueenPiece;
import states.HealthyState;

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
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        QueenPiece queen = builder.getResult();
        queen.setState(new HealthyState(queen));
        return queen;
    };

    @Override
    public QueenPiece createBlackPiece(QueenPieceBuilder builder) {
        builder.setAllegiance(this.blackAllegiance);
        builder.setState();
        builder.setHealth();
        builder.setArmor();
        builder.setDamage();
        QueenPiece queen = builder.getResult();
        queen.setState(new HealthyState(queen));
        return queen;
    };
}
