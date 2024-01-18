import board.Board;
import board.Square;
import pieces.Piece;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

        Board board = new Board();

        board.initialiseBoard();

        board.printBoard();

        String incomingCommand = reader.readLine();
        String[] parts = incomingCommand.split(" ");
        if (parts[0].equals("Move")) {
            if(parts.length == 3) {
                boolean errorDetected = false;

                int currentSquareXCoordinate = 0;
                int currentSquareYCoordinate = 0;

                int squareToMoveToXCoordinate = 0;
                int squareToMoveToYCoordinate = 0;
                try {
                    currentSquareXCoordinate = Integer.parseInt(parts[1].split(",")[0]);
                    currentSquareYCoordinate = Integer.parseInt(parts[1].split(",")[1]);

                    squareToMoveToXCoordinate = Integer.parseInt(parts[2].split(",")[0]);
                    squareToMoveToYCoordinate = Integer.parseInt(parts[2].split(",")[1]);
                } catch (NumberFormatException err) {
                    errorDetected = true;
                    writer.writeLine("Invalid integer input");
                }
                if (!errorDetected) {
                    Square startSquare = board.getSquare(currentSquareXCoordinate, currentSquareYCoordinate);
                    Square newSquare = board.getSquare(squareToMoveToXCoordinate, squareToMoveToYCoordinate);
                    Piece piece = startSquare.getPiece();

                    piece.move(startSquare, newSquare, null);

                    board.printBoard();
                }
            } else {
                if (parts.length < 3) {
                    writer.writeLine("Command missing parameters");
                } else {
                    writer.writeLine("Command contains too many parameters");
                }
            }
        } else if (parts[0].equals("Attack")) {

        } else if (parts[0].equals("Special-action")) {

        } else if (parts[0].equals("Restore")) {

        } else if (parts[0].equals("Undo-turn")) {

        }else if (parts[0].equals("End")) {

        } else {
            writer.writeLine("Command not recognized");
        }

        if (reader.readLine().equals("move")) {
            Square someSquare = board.getSquare(1, 1);
            Square newSquare = board.getSquare(1, 2);
            Piece piece = someSquare.getPiece();

            piece.move(someSquare, newSquare, null);

            board.printBoard();
        }
    }
}