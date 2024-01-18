package board;

public class Memento {
    private Board board;

    private Square[][] squares;

    public Memento(Board board, Square[][] squares) {
        this.board = board;
        this.squares = squares;
    }

    public void restore() {
        this.board.setSquares(this.squares);
    }
}
