package board;

import pieces.Piece;

public class Square {
    private Piece piece;
    private final int x;
    private final int y;

    public Square(int x, int y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
