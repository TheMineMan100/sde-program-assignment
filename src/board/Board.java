package board;

import allegiances.Black;
import allegiances.White;
import factories.*;
import pieces.Piece;

public class Board {
    private Square[][] squares;

    private White whiteAllegiance;

    private Black blackAllegiance;

    private PawnPieceFactory pawnFactory;

    private RookPieceFactory rookFactory;

    private BishopPieceFactory bishopFactory;

    private KnightPieceFactory knightFactory;

    private QueenPieceFactory queenFactory;

    private KingPieceFactory kingFactory;

    public Board() {
        this.squares = new Square[8][8];

        this.whiteAllegiance = new White();
        this.blackAllegiance = new Black();

        this.pawnFactory = new PawnPieceFactory(whiteAllegiance, blackAllegiance);
        this.rookFactory = new RookPieceFactory(whiteAllegiance, blackAllegiance);
        this.bishopFactory = new BishopPieceFactory(whiteAllegiance, blackAllegiance);
        this.knightFactory = new KnightPieceFactory(whiteAllegiance, blackAllegiance);
        this.queenFactory = new QueenPieceFactory(whiteAllegiance, blackAllegiance);
        this.kingFactory = new KingPieceFactory(whiteAllegiance, blackAllegiance);
    }

    public void initialiseBoard() {
        System.out.println("Starting initialisation...");

        // Setup white pieces
        this.squares[0][0] = new Square(0, 0, rookFactory.createWhitePiece());
        this.squares[1][0] = new Square(1, 0, knightFactory.createWhitePiece());
        this.squares[2][0] = new Square(2, 0, bishopFactory.createWhitePiece());
        this.squares[3][0] = new Square(3, 0, queenFactory.createWhitePiece());
        this.squares[4][0] = new Square(4, 0, kingFactory.createWhitePiece());
        this.squares[5][0] = new Square(5, 0, bishopFactory.createWhitePiece());
        this.squares[6][0] = new Square(6, 0, knightFactory.createWhitePiece());
        this.squares[7][0] = new Square(7, 0, rookFactory.createWhitePiece());
        this.squares[0][1] = new Square(0, 1, pawnFactory.createWhitePiece());
        this.squares[1][1] = new Square(1, 1, pawnFactory.createWhitePiece());
        this.squares[2][1] = new Square(2, 1, pawnFactory.createWhitePiece());
        this.squares[3][1] = new Square(3, 1, pawnFactory.createWhitePiece());
        this.squares[4][1] = new Square(4, 1, pawnFactory.createWhitePiece());
        this.squares[5][1] = new Square(5, 1, pawnFactory.createWhitePiece());
        this.squares[6][1] = new Square(6, 1, pawnFactory.createWhitePiece());
        this.squares[7][1] = new Square(7, 1, pawnFactory.createWhitePiece());

        // Setup black pieces
        this.squares[0][6] = new Square(0, 6, pawnFactory.createBlackPiece());
        this.squares[1][6] = new Square(1, 6, pawnFactory.createBlackPiece());
        this.squares[2][6] = new Square(2, 6, pawnFactory.createBlackPiece());
        this.squares[3][6] = new Square(3, 6, pawnFactory.createBlackPiece());
        this.squares[4][6] = new Square(4, 6, pawnFactory.createBlackPiece());
        this.squares[5][6] = new Square(5, 6, pawnFactory.createBlackPiece());
        this.squares[6][6] = new Square(6, 6, pawnFactory.createBlackPiece());
        this.squares[7][6] = new Square(7, 6, pawnFactory.createBlackPiece());
        this.squares[0][7] = new Square(0, 7, rookFactory.createBlackPiece());
        this.squares[1][7] = new Square(1, 7, knightFactory.createBlackPiece());
        this.squares[2][7] = new Square(2, 7, bishopFactory.createBlackPiece());
        this.squares[3][7] = new Square(3, 7, queenFactory.createBlackPiece());
        this.squares[4][7] = new Square(4, 7, kingFactory.createBlackPiece());
        this.squares[5][7] = new Square(5, 7, bishopFactory.createBlackPiece());
        this.squares[6][7] = new Square(6, 7, knightFactory.createBlackPiece());
        this.squares[7][7] = new Square(7, 7, rookFactory.createBlackPiece());

        // Other squares without pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.squares[j][i] = new Square(j, i, null);
            }
        }

        System.out.println("Initialisation complete!");
    }

    public Square getSquare(int posX, int posY) {
        return squares[posX][posY];
    }

    public void printBoard() {
        String[] boardToPrint = new String[8];

        for (int i = 7; i > -1; i--) {
            String lineToPrint = "";

            for (int j = 7; j > -1; j--) {
                Piece piece = this.squares[j][i].getPiece();
                String pieceSymbol = "";
                if (piece != null) {
                    pieceSymbol = this.squares[j][i].getPiece().getSymbol();
                }
                if (piece != null && pieceSymbol != null && ! pieceSymbol.isEmpty()) {
                    lineToPrint += pieceSymbol;
                } else {
                    lineToPrint += "⛋";
                }
            }
            boardToPrint[i] = lineToPrint;
            System.out.println(boardToPrint[i]);
        }
        System.out.println("\n");
    }
}
