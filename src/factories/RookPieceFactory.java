package factories;

import allegiances.Allegiance;
import builders.RookPieceBuilder;
import pieces.RookPiece;
import states.HealthyState;
import states.NullState;

public class RookPieceFactory implements PieceFactory<RookPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private RookPieceBuilder builder;

    public RookPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
        this.builder = new RookPieceBuilder();
    };

    @Override
    public RookPiece createWhitePiece() {
        this.builder.setAllegiance(this.whiteAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(3);
        this.builder.setArmor(3);
        this.builder.setDamage(2);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♖");

        RookPiece rook = this.builder.getResult();
        rook.changeState(new HealthyState(rook));

        return rook;
    };

    @Override
    public RookPiece createBlackPiece() {
        this.builder.setAllegiance(this.blackAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(3);
        this.builder.setArmor(3);
        this.builder.setDamage(2);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♜");

        RookPiece rook = this.builder.getResult();
        rook.changeState(new HealthyState(rook));

        return rook;
    };
}
