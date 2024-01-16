import pieces.Piece;

public class Board {

    Square[][] squares;

    public Board() {

    }

    public void initialiseBoard() {
        // Setup white pieces
        this.squares[0][0] = new Square(0, 0, new Piece());
        this.squares[1][0] = new Square(1, 0, new Piece());
        this.squares[2][0] = new Square(2, 0, new Piece());
        this.squares[3][0] = new Square(3, 0, new Piece());
        this.squares[4][0] = new Square(4, 0, new Piece());
        this.squares[5][0] = new Square(5, 0, new Piece());
        this.squares[6][0] = new Square(6, 0, new Piece());
        this.squares[7][0] = new Square(7, 0, new Piece());
        this.squares[0][1] = new Square(0, 1, new Piece());
        this.squares[1][1] = new Square(1, 1, new Piece());
        this.squares[2][1] = new Square(2, 1, new Piece());
        this.squares[3][1] = new Square(3, 1, new Piece());
        this.squares[4][1] = new Square(4, 1, new Piece());
        this.squares[5][1] = new Square(5, 1, new Piece());
        this.squares[6][1] = new Square(6, 1, new Piece());
        this.squares[7][1] = new Square(7, 1, new Piece());

        // Setup black pieces
        this.squares[0][6] = new Square(0, 6, new Piece());
        this.squares[1][6] = new Square(1, 6, new Piece());
        this.squares[2][6] = new Square(2, 6, new Piece());
        this.squares[3][6] = new Square(3, 6, new Piece());
        this.squares[4][6] = new Square(4, 6, new Piece());
        this.squares[5][6] = new Square(5, 6, new Piece());
        this.squares[6][6] = new Square(6, 6, new Piece());
        this.squares[7][6] = new Square(7, 6, new Piece());
        this.squares[0][7] = new Square(0, 7, new Piece());
        this.squares[1][7] = new Square(1, 7, new Piece());
        this.squares[2][7] = new Square(2, 7, new Piece());
        this.squares[3][7] = new Square(3, 7, new Piece());
        this.squares[4][7] = new Square(4, 7, new Piece());
        this.squares[5][7] = new Square(5, 7, new Piece());
        this.squares[6][7] = new Square(6, 7, new Piece());
        this.squares[7][7] = new Square(7, 7, new Piece());

        // Other squares without pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.squares[j][i] = new Square(j, i, null);
            }
        }
    }
}
