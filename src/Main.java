public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

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
                    writer.writeLine(String.valueOf(currentSquareXCoordinate));
                    writer.writeLine(String.valueOf(currentSquareYCoordinate));
                    writer.writeLine(String.valueOf(squareToMoveToXCoordinate));
                    writer.writeLine(String.valueOf(squareToMoveToYCoordinate));
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

        writer.writeLine("Hello world!");
        System.out.println("Hello world!");
    }
}