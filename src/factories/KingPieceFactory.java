package factories;

import allegiances.Allegiance;
import builders.KingPieceBuilder;
import pieces.KingPiece;
import states.HealthyState;
import states.NullState;

public class KingPieceFactory implements PieceFactory<KingPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private KingPieceBuilder builder;

    public KingPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
        this.builder = new KingPieceBuilder();
    };

    @Override
    public KingPiece createWhitePiece() {
        this.builder.setAllegiance(this.whiteAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(5);
        this.builder.setArmor(2);
        this.builder.setDamage(4);
        this.builder.setSymbol("♔");

        KingPiece king = this.builder.getResult();
        king.changeState(new HealthyState(king));

        return king;
    };

    @Override
    public KingPiece createBlackPiece() {
        this.builder.setAllegiance(this.blackAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(5);
        this.builder.setArmor(2);
        this.builder.setDamage(3);
        this.builder.setSymbol("♚");

        KingPiece king = this.builder.getResult();
        king.changeState(new HealthyState(king));

        return king;
    };
}
