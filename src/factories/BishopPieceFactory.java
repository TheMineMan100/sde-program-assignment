package factories;

import allegiances.Allegiance;
import builders.BishopPieceBuilder;
import pieces.BishopPiece;
import states.HealthyState;
import states.NullState;

public class BishopPieceFactory implements PieceFactory<BishopPieceBuilder> {
    private final Allegiance whiteAllegiance;

    private final Allegiance blackAllegiance;

    private BishopPieceBuilder builder;

    public BishopPieceFactory(Allegiance whiteAllegiance, Allegiance blackAllegiance) {
        this.whiteAllegiance = whiteAllegiance;
        this.blackAllegiance = blackAllegiance;
        this.builder = new BishopPieceBuilder();
    }

    @Override
    public BishopPiece createWhitePiece() {
        this.builder.setAllegiance(this.whiteAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(3);
        this.builder.setArmor(0);
        this.builder.setDamage(2);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♗");

        BishopPiece bishop = this.builder.getResult();
        bishop.changeState(new HealthyState(bishop));

        return bishop;
    };

    @Override
    public BishopPiece createBlackPiece() {
        this.builder.setAllegiance(this.blackAllegiance);
        this.builder.setState(new NullState());
        this.builder.setHealth(3);
        this.builder.setArmor(0);
        this.builder.setDamage(2);
        this.builder.setCanMove(true);
        this.builder.setCanAttack(true);
        this.builder.setSymbol("♝");

        BishopPiece bishop = this.builder.getResult();
        bishop.changeState(new HealthyState(bishop));

        return bishop;
    };
}
