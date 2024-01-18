package factories;

import builders.PieceBuilder;
import pieces.Piece;

public interface PieceFactory<T> {
    public Piece createWhitePiece(T builder);
    public Piece createBlackPiece(T builder);
}
