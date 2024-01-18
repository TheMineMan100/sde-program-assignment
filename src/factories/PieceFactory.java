package factories;

import builders.PieceBuilder;
import pieces.Piece;

public interface PieceFactory<T> {
    public Piece createWhitePiece();
    public Piece createBlackPiece();
}
