# Our Program

To finish the course "Software Design" we were tasked with making a program using some of the design patterns we had learnt. We had to work in pairs, in order to be able to discuss with one another about how and when to apply the design patterns, which would hopefully result in a better program. 

The program should run in a java console. We decided on making a chess program, but with our own twist. It's the normal chess board and pieces you know and love, but with RPG mechanics integrated into it. The program's rules should be as follows:

    Per turn the player can move once and attack once, or move once and do a special action once
        - This does not have to be done with the same piece
        - The player must always move a piece, attacking or doing a special action is voluntary

    Pieces can move like normal chess pieces

    If a piece lands on an enemy piece they perform an attack using their damage against the 
    opponent's health and armour
        - The pawn is of course an exception, only moving forward and only hitting diagonally up 
        left or up right.
        - If the damage the piece does isn't enough to kill the enemy piece, neither piece moves

    Pieces can perform piece-specific special actions on any piece they could land on. This means 
    they don't actually move
        Pawn:
            - As usual special ability only hits diagonally
            - Allows the pawn to sacrifice itself to deal double damage to a piece
        Rook:
            - Applies Stunned state to an enemy piece in its movement range
            - Stunned makes the piece unable to move for the next turn, after which it returns to 
            default (healthy) state
        Bishop:
            - Applies Healing state (regeneration) to a friendly piece in its movement range
            - Healing state heals X health per turn for 3 turns, then returns to default (healthy) 
            state
        Knight:
            - Applies Poisoned state to an enemy piece in its movement range
            - Poisoned makes the piece lose X% of its damage stat for 3 turns
            - Afterwards returns to default (healthy) state with its damage returned to normal
        Queen:
            - Can only be used at the start of the turn
            - Generates a random number between 1 and 6
            - If the number is high enough (4, 5 or 6), allows the queen to move/attack twice
            - If not, the player's turn ends without moving/attacking
        King:
            - AOE attack that hits in a 2 square radius around the king and deals large damage
            - Gives the king the Stunned state for the next turn

Before we go to the actual use of the program via console commands, we'll have to explain how the coordinates work in our chess app. Coordinate 0,0 references the bottom left square on the board. Coordinate 7,7 references the upper right square on the board. The coordinates should be: "x,y".

The possible commands to put in the console are:

    Move {coordinates of square containing the piece to be moved} {coordinates of square to 
    move piece to}

    Attack {coordinates of square containing the attacking piece} {coordinates of square 
    containing the piece to be attacked}

    For Pawn, Rook, Bishop, Knight:
    Special-action {coordinates of square contain the piece doing the special move} {coordinates 
    of square containing the piece to be affected by the special action}

    For Queen, King:
    Special-action {coordinates of square contain the piece doing the special move}

    Restore {turn number}

    Undo-turn

    End

Example of using coordinates: Move 0,1 0,3. This will move the piece on the square with coordinates x=0 and y=1 to the square with coordinates x=0 and y=3.

The command "Restore", restores the game to the beginning of a turn that is signified with the given turn number. When starting the game, the game starts with turn 0. When the white player has ended his turn, before the black player makes any actions the new state of the board will be saved as turn 1. You can use "Undo turn" to go back to the start of the current turn. If you're in turn 1 for example and black made his moves but regrets them, you can use this command to go back to the beginning of turn 1 where black hasn't made any moves yet.

The command "end", ends the turn of the current player.

# Cooperation


Here we describe the way we worked together

# Design Patterns

We worked on 6 design patterns in total. The creational patterns are the builder and factory methods. The structural patterns are the bridge and facade methods. The behavioral patterns are the state and memento methods.

## Creational Patterns

### Builder

The builder method(s) can be found in the "builders" folder/package. There is 1 interface and 6 builders for the 6 different pieces. When creating the builder or calling the function reset, a new chess piece is made. With other methods inside the builder you can put values inside the chess piece object. These values are given via parameters to the functions. Via the getResult() you get the built chess piece returned. The builder automatically resets inside the getResult();

### Factory

The factory method(s) can be found in the "factories" folder/package. There is 1 interface and 6 factories for the 6 different pieces. A factory makes use of the relevant builder to fabricate a new piece. This piece is standardized in its values. There are 2 functions in each factory, "createWhitePiece" and "createBlackPiece". In the factories constructor the 2 colors (the colors are objects) and the builder to be used are defined. When using one of the 2 methods, you get a chess piece object returned.

## Structural Patterns

### Bridge

The relevant files for the bridge method can be found in the "allegiances" and "pieces" folders/packages. Every chess piece contains an allegiance object, namely black or white. The allegiance gives methods for moving, attacking and doing special actions (which can be different for either black or white pawns). This prevents us from having classes like "BlackPawnPiece" and "WhitePawnPiece", instead being able to just create a "PawnPiece" with an object of its "Allegiance" inside.

### Facade

Our "Main.java" file is our entry point to the program and a facade. It provides a simplified interface to our program, by enabling the player(s) to input simple commands in the command line and then automatically calling to other classes, instead of forcing the player to call to those classes themselves. For example, when ending the turn the curent player doesn't need to change players or save the current state of the board as a Memento, that's done automatically via 1 command.

## Behavioral Patterns

### State

The state method(s) can be found in the "states" folder/package. Every piece has a state. The "normal" state is the "HealthyState". This has no special effects. Via special actions by the players, pieces can gain different states like "StunnedState" and "PoisonedState", which will stop a piece from moving and make a piece take damage every turn. These states have a certain duration before they change back to the "HealthyState". When a new special action is taken against the pawn before the duration is up, the new State caused by the special action will overwrite the previous "special state". For example when a pawn is in a "PoisonedState" and gets stunned, it will change to the "StunnedState". No effects from the "PoisonedState" will apply after that. This enables most States to be reached by most other States.

### Memento

The memento method can be found in the "board" folder/package. This method enables us to save older versions/states of the chess board. The "Board" class contains 2 relevant functions: a function to set its "squares" to the squares that were provided via a parameter and a method to create a new "Memento" object and thus save the current version of the board. The "Memento" class has a reference to the instantiated board object and has an array of every "square" at the time of saving the board. When the function "restore" of a Memento object is called, it will set the squares of the current board to the squares variable inside the Memento class. A class "HistoryCaretaker" manages all of the saving and restoring. It too contains a reference to the instantiated board object and it has an array "history" filled with Memento objects of every turn. At the beginning of a new turn, the function "saveMemento" calls to the save function of the board and adds the returned "Memento" object to the history array. When its function "restoreMemento" is called, it calls in turn to "restore" function of the Memento of the turn specified in the parameter of the function. "restoreLastMemento" restores the last Memento saved in the "history" array.