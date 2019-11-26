public class Mho extends MovePiece {

    Player player = new Player();


    public Mho(int x, int y) {
        this.x = x;
        this.y = y;
        alive = true;
    }

    public BoardPiece[][] moveMho(BoardPiece[][] objectLocations) { //first priority: kill player
        for(int i = 0; i < GameFrame.boardWidth; i++){
            for(int j = 0; j < GameFrame.boardHeight; j++){
                if(objectLocations[i][j] instanceof Player){
                    player.initPlayer(i,j);
                }
            }
        }
        this.objectLocations = objectLocations;
        inLine();
        return objectLocations;
    }

    private void inLine() {
        //Checks if Mho is in line with player. Must move in that direction
        if (player.y == y) { //horizontal to player
            if (player.x > x) {
                if (checkFence(x + 1, y) && !checkMho(x + 1, y)) { //moved onto fence
                    killMho();
                } else if (!checkMho(x + 1, y)) {
                    moveRight(objectLocations);
                }
            } else if (player.x < x) {
                if (checkFence(x - 1, y) && !checkMho(x - 1, y)) {
                    killMho();
                } else if (!checkMho(x - 1, y)) {
                    moveLeft(objectLocations);
                }
            }
        } else if (player.x == x) { //vertical to player
            if (player.y > y) {
                if (checkFence(x, y + 1) && !checkMho(x, y + 1)) { //moved onto fence
                    killMho();
                } else if (!checkMho(x, y + 1)) {
                    moveDown(objectLocations);
                }
            } else if (player.y < y) {
                if (checkFence(x, y - 1) && !checkMho(x, y - 1)) {
                    killMho();
                } else if (!checkMho(x, y - 1)) {
                    moveUp(objectLocations);
                }
            }
        } else {
            diagonalMove();
        }
    }

    private void diagonalMove() {
        // Checks if Mho can move diagonally onto open space
        if (player.x > x) { // if mho is left of player
            if (player.y > y) {
                if (checkOpen(x + 1, y + 1)) {
                    moveDownRight(objectLocations);
                } else {
                    horizontalMove();
                }
            } else if (player.y < y) {
                if (checkOpen(x + 1, y - 1)) {
                    moveUpRight(objectLocations);
                } else {
                    horizontalMove();
                }
            }
        } else if (player.x < x) { // if mho is left of player
            if (player.y > y) {
                if (checkOpen(x - 1, y + 1)) {
                    moveDownLeft(objectLocations);
                } else {
                    horizontalMove();
                }
            } else if (player.y < y) {
                if (checkOpen(x - 1, y - 1)) {
                    moveUpLeft(objectLocations);
                } else {
                    horizontalMove();
                }
            }
        } else {
            horizontalMove();
        }
    }

    private void horizontalMove() {
        // Checks if Mho can move horizontally or vertically onto open space
        if (Math.abs(player.x - x) >= Math.abs(player.y - y)) { // if vert dist greater than horiz dist
            if (player.x > x) { // if mho is under player
                if (checkOpen(x + 1, y)) {
                    moveRight(objectLocations);
                } else {
                    diagonalOntoFence();
                }
            } else if (player.x < x) {
                if (checkOpen(x - 1, y)) {
                    moveLeft(objectLocations);
                } else {
                    diagonalOntoFence();
                }
            }
        } else if (Math.abs(player.y - y) >= Math.abs(player.x - x)) { // if vert dist greater than horiz dist
            if (player.y > y) { // if mho is under player
                if (checkOpen(x, y + 1)) {
                    moveDown(objectLocations);
                } else {
                    diagonalOntoFence();
                }
            } else if (player.y < y) {
                if (checkOpen(x, y - 1)) {
                    moveUp(objectLocations);
                } else {
                    diagonalOntoFence();
                }
            }
        } else {
            diagonalOntoFence();
        }
    }

    private void diagonalOntoFence() {
        //Checks if Mho can move onto diagonally fence
        if (player.x > x) {
            if (player.y > y) {
                if (checkFence(x + 1, y + 1) && !checkMho(x + 1, y + 1)) { //Checks for fence and not Mho
                    killMho();
                } else {
                    horizontalOntoFence();
                }
            } else if (player.y < y) {
                if (checkFence(x + 1, y - 1) && !checkMho(x + 1, y - 1)) {
                    killMho();
                } else {
                    horizontalOntoFence();
                }
            }
        } else if (player.x < x) { // if mho is left of player
            if (player.y > y) {
                if (checkFence(x - 1, y + 1) && !checkMho(x - 1, y + 1)) {
                    killMho();
                } else {
                    horizontalOntoFence();
                }
            } else if (player.y < y) {
                if (checkFence(x - 1, y - 1) && !checkMho(x - 1, y - 1)) {
                    killMho();
                } else {
                    horizontalOntoFence();
                }
            }
        }
    }

    private void horizontalOntoFence() {
        // Checks if Mho can move either horizontally or vertically onto a fence
        if (Math.abs(player.x - x) >= Math.abs(player.y - y)) { // if vert dist greater than horiz dist
            if (player.x > x) { // if mho is under player
                if (checkFence(x + 1, y) && !checkMho(x + 1, y)) { //Checks if there is a fence and no Mho
                    killMho();
                }
            } else if (player.x < x) {
                if (checkFence(x - 1, y) && !checkMho(x - 1, y)) {
                    killMho();
                }
            }
        } else if (Math.abs(player.y - y) >= Math.abs(player.x - x)) { // if vert dist greater than horiz dist
            if (player.y > y) { // if mho is under player
                if (checkFence(x, y + 1) && !checkMho(x, y + 1)) {
                    killMho();
                }
            } else if (player.y < y) {
                if (checkFence(x, y - 1) && !checkMho(x, y - 1)) {
                    killMho();
                }
            }
        }
    }

    private boolean checkOpen(int xloc, int yloc) {
        //Returns true if a that location is open
        boolean retval = false;
        if (objectLocations[xloc][yloc] instanceof BlankSpace || objectLocations[xloc][yloc] instanceof Player) {
            retval = true;
        }
        return retval;
    }

    private boolean checkFence(int xloc, int yloc) {
        //Return true if a fence is at that location,
        boolean retval = false;
        if (objectLocations[xloc][yloc] instanceof Fence) {
            retval = true;
        }
        return retval;
    }

    private boolean checkMho(int xloc, int yloc) {
        //Return true if an Mho is at xloc,yloc
        boolean retval = false;
        if (objectLocations[xloc][yloc] instanceof Mho){
            retval = true;
        }
        return retval;
    }

    private void killMho() {
        alive = false;
        objectLocations[x][y] = new BlankSpace();
    }
}
