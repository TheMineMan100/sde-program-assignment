package builders;

import allegiances.Allegiance;
import pieces.QueenPiece;
import states.PieceState;

public class QueenPieceBuilder implements PieceBuilder {
    private QueenPiece queen = new QueenPiece();

    @Override
    public void reset() {
        this.queen = new QueenPiece();
    }

    @Override
    public void setAllegiance(Allegiance allegiance) {
        this.queen.setAllegiance(allegiance);
    }

    @Override
    public void setState(PieceState state) {
        this.queen.changeState(state);
    }

    @Override
    public void setHealth(double health) {
        this.queen.setHealth(health);
    }

    @Override
    public void setArmor(int armor) {
        this.queen.setArmor(armor);
    }

    @Override
    public void setDamage(double damage) {
        this.queen.setDamage(damage);
    }

    @Override
    public void setCanMove(Boolean canMove) {
        this.queen.setCanMove(canMove);
    }

    @Override
    public void setCanAttack(Boolean canAttack) {
        this.queen.setCanAttack(canAttack);
    }

    @Override
    public void setSymbol(String symbol) {
        this.queen.setSymbol(symbol);
    }

    public QueenPiece getResult() {
        QueenPiece result = this.queen;
        this.reset();
        return result;
    }
}
