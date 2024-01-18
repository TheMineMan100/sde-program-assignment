import board.Board;
import board.Square;
import pieces.Piece;

public class Main {
    public static void main(String[] args) {
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();

        writer.writeLine("Hello world!");
        System.out.println("Hello world!");

        Board board = new Board();

        board.initialiseBoard();

        board.printBoard();

        if (reader.readLine().equals("move")) {
            Square someSquare = board.getSquare(1, 1);
            Square newSquare = board.getSquare(1, 2);
            Piece piece = someSquare.getPiece();

            piece.move(someSquare, newSquare, null);

            board.printBoard();
        }
    }
}