public class MovePiece extends BoardPiece{ //Superclass for both Mho and Player
    boolean alive;
    BoardPiece[][] objectLocations;

    public BoardPiece[][] moveRight(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations; //Sets field to parameter of same name
        objectLocations[this.x][this.y] = new BlankSpace(); // Clears previous location
        x = x + 1; // Changes position fields
        movePieceIfSpaceOpen(); //Moves within 2d array
        return objectLocations;
    }

    public BoardPiece[][] moveLeft(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        x = x - 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveDown(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        y = y + 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveUp(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        y = y - 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveUpRight(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        x = x + 1;
        y = y - 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveUpLeft(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        x = x - 1;
        y = y - 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveDownRight(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        y = y + 1;
        x = x + 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    public BoardPiece[][] moveDownLeft(BoardPiece[][] objectLocations) {
        this.objectLocations = objectLocations;
        objectLocations[this.x][this.y] = new BlankSpace();
        y = y + 1;
        x = x - 1;
        movePieceIfSpaceOpen();
        return objectLocations;
    }

    private boolean spaceNotOccupiedByFenceOrMho() { // checks for open space
        return !(objectLocations[this.x][this.y] instanceof Fence) && !(objectLocations[this.x][this.y] instanceof Mho);
    }

    private void movePieceIfSpaceOpen() {
        if(spaceNotOccupiedByFenceOrMho()) {
            objectLocations[this.x][this.y] = this; //Moves piece if space open
        } else {
            this.alive = false; //Kills if space occupied by fence or mho
        }
    }
}
