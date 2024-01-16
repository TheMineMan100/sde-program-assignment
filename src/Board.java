public class Board {

    Spot[][] spots;

    public Board() {

    }

    public void initialiseBoard() {
        // Setup white pieces
        this.spots[0][0] = new Spot(0, 0, new Piece());
        this.spots[1][0] = new Spot(1, 0, new Piece());
        this.spots[2][0] = new Spot(2, 0, new Piece());
        this.spots[3][0] = new Spot(3, 0, new Piece());
        this.spots[4][0] = new Spot(4, 0, new Piece());
        this.spots[5][0] = new Spot(5, 0, new Piece());
        this.spots[6][0] = new Spot(6, 0, new Piece());
        this.spots[7][0] = new Spot(7, 0, new Piece());
        this.spots[0][1] = new Spot(0, 1, new Piece());
        this.spots[1][1] = new Spot(1, 1, new Piece());
        this.spots[2][1] = new Spot(2, 1, new Piece());
        this.spots[3][1] = new Spot(3, 1, new Piece());
        this.spots[4][1] = new Spot(4, 1, new Piece());
        this.spots[5][1] = new Spot(5, 1, new Piece());
        this.spots[6][1] = new Spot(6, 1, new Piece());
        this.spots[7][1] = new Spot(7, 1, new Piece());

        // Setup black pieces
        this.spots[0][6] = new Spot(0, 6, new Piece());
        this.spots[1][6] = new Spot(1, 6, new Piece());
        this.spots[2][6] = new Spot(2, 6, new Piece());
        this.spots[3][6] = new Spot(3, 6, new Piece());
        this.spots[4][6] = new Spot(4, 6, new Piece());
        this.spots[5][6] = new Spot(5, 6, new Piece());
        this.spots[6][6] = new Spot(6, 6, new Piece());
        this.spots[7][6] = new Spot(7, 6, new Piece());
        this.spots[0][7] = new Spot(0, 7, new Piece());
        this.spots[1][7] = new Spot(1, 7, new Piece());
        this.spots[2][7] = new Spot(2, 7, new Piece());
        this.spots[3][7] = new Spot(3, 7, new Piece());
        this.spots[4][7] = new Spot(4, 7, new Piece());
        this.spots[5][7] = new Spot(5, 7, new Piece());
        this.spots[6][7] = new Spot(6, 7, new Piece());
        this.spots[7][7] = new Spot(7, 7, new Piece());

        // Other spots without pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.spots[j][i] = new Spot(j, i, null);
            }
        }
    }
}
