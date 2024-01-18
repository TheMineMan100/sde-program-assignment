package builders;

import allegiances.Allegiance;
import pieces.RookPiece;
import states.PieceState;

public class RookPieceBuilder implements PieceBuilder {
    private RookPiece rook = new RookPiece();

    @Override
    public void reset() {
        this.rook = new RookPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.rook.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.rook.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.rook.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.rook.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.rook.setDamage(damage);
    }

    @Override
    public void setCanMove(Boolean canMove) {
        this.rook.setCanMove(canMove);
    }

    @Override
    public void setCanAttack(Boolean canAttack) {
        this.rook.setCanAttack(canAttack);
    }

    @Override
    public void setSymbol(String symbol) {
        this.rook.setSymbol(symbol);
    }

    public RookPiece getResult() {
        RookPiece result = this.rook;
        this.reset();
        return result;
    }
}
