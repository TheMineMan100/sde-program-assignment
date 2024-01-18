import board.Board;
import board.HistoryCaretaker;
import board.Square;
import pieces.Piece;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

        Board board = new Board();

        board.initialiseBoard();

        board.printBoard();

        HistoryCaretaker historyCareTaker = new HistoryCaretaker(board);

        boolean whitePlayerTurn = true;
        boolean hasMoved = false;
        boolean hasAttacked = false;

        gameLoop(
            reader,
            writer,
            board,
            historyCareTaker,
            whitePlayerTurn,
            hasMoved,
            hasAttacked
        );
    }

    public static void gameLoop(
            ConsoleReader reader,
            ConsoleWriter writer,
            Board board,
            HistoryCaretaker historyCareTaker,
            boolean whitePlayerTurn,
            boolean hasMoved,
            boolean hasAttacked
    ) {
        boolean stopGame = false;

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
                    Square currentSquare = board.getSquare(currentSquareXCoordinate, currentSquareYCoordinate);
                    Square squareToMoveTo = board.getSquare(squareToMoveToXCoordinate, squareToMoveToYCoordinate);

                    Piece piece = currentSquare.getPiece();

                    piece.move(currentSquare, squareToMoveTo, board.getSquares());

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

        } else if (parts[0].equals("End")) {
            if (hasMoved) {
                if (whitePlayerTurn) {
                    whitePlayerTurn = false;
                    hasMoved = false;
                    hasAttacked = false;
                } else {
                    whitePlayerTurn = true;
                    hasMoved = false;
                    hasAttacked = false;
                }
            } else {
                writer.writeLine("You HAVE to move");
            }
        } else if (parts[0].equals("Stop")) {
            stopGame = true;
        } else {
            writer.writeLine("Command not recognized");
        }

        if (!stopGame) {
            gameLoop(
                    reader,
                    writer,
                    board,
                    historyCareTaker,
                    whitePlayerTurn,
                    hasMoved,
                    hasAttacked
            );
        }
    }
}