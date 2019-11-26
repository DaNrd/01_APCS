# SimpleChess

**Version 1:** This is the first version of a chess game. Currently it just draws a resizeable game board with different colored circles representing the different pieces.

**Version 2:** The board now shows where a clicked piece can move

**Version 3:** The pieces can now move!!!

**Version 4:** The pieces no have sprites and some movement errors resolved.

**Next Steps:** Add castling, check detection, and have pawns become queens when crossing the board.

### Errors

Played a few games, besides pawns not changing once they reach the other side, the lack of a castling ability, and no check/checkmate indication allowing the game to continue once the king is dead, it works perfectly.

### Code Overview

SimpleChess.Java

    - creates instance of game
    
    - runs init in GameBoard.java
    
    - records clicks

GameBoard.java

	- draws board and pieces
	
	- deals with movement

### Project Scope

- Lines of Code:
    - Version 1 - **241**
    - Version 2 - ****
    - Version 3 - **546**
    - Version 3 - **548**
- Number of Classes:
    - Version 1 - **2**
    - Version 2 - **2**
    - Version 3 - **2**
    - Version 4 - **2**
- Number of Methods:
    - Version 1 - **22**
    - Version 2 - **38**
    - Version 3 - **39**
    - Version 4 - **39**
- Depth of the Class Hierarchy:
    - Version 1 - **0**
    - Version 2 - **0**
    - Version 3 - **0**
    - Version 4 - **0**
- Lexical Method Call Depth:
    - Version 1 - **3**
    - Version 2 - **6**
    - Version 3 - **6**
    - Version 4 - **6**
- Dynamic Method Call Depth:
    - Version 1 - **3**
    - Version 2 - **6**
    - Version 3 - **6**
    - Version 4 - **6**
- Complexity of Inter-Method Interaction:
    - Version 1 - **1/10**
    - Version 2 - **6/10**
    - Version 3 - **8/10**
    - Version 4 - **8/10**
- Run Time:
    - Version 1 - **forever (but realistically about 1 min max)**
    - Version 2 - **shows possible moves but that's it**
    - Version 3 - **pieces move noe so could play but all same sprite so doesn't make sense**
    - Version 4 - **game functions so can be played until game is over**
- Rate Of Growth Of Run Time:
    - Version 1 - **N/A**
    - Version 2 - **N/A**
    - Version 3 - **N/A**
    - Version 4 - **N/A**
- Iteration Nesting Depth:
    - Version 1 - **2**
    - Version 2 - **2**
    - Version 3 - **2**
    - Version 4 - **2**