public class Npc {
    // This class deals with Mhos. It stores Mho locations as int fields, alive status as a bool, and movement as methods.
    int xpos;
    int ypos;
    boolean alive;

    public Npc(int x, int y){
        xpos = x;
        ypos = y;
        alive = true;
    }

    public void npcMove() {
        inLine();
    }

    private void inLine() {
        //Checks if Mho is in line with player. Must move in that direction
        if(GameFrame.y == ypos){
            if(GameFrame.x > xpos){
                if(checkFence(xpos+1, ypos)){
                    alive = false;
                }
                xpos++;
            } else if(GameFrame.x < xpos){
                if(checkFence(xpos-1, ypos)){
                    alive = false;
                }
                xpos--;
            }
        } else if(GameFrame.x == xpos) {
            if (GameFrame.y > ypos) {
                if(checkFence(xpos, ypos+1)){
                    alive = false;
                }
                ypos++;
            } else if (GameFrame.y < ypos) {
                if(checkFence(xpos, ypos-1)){
                    alive = false;
                }
                ypos--;
            }
        } else {
            diagonalMove();
        }
    }

    private void diagonalMove() {
        // Checks if Mho can move diagonally onto open space
        if (GameFrame.x > xpos) { // if mho is left of player
            if (GameFrame.y > ypos) {
                if (checkOpen(xpos + 1, ypos + 1)) {
                    xpos++;
                    ypos++;
                } else {
                    horizontalMove();
                }
            } else if(GameFrame.y < ypos){
                if (checkOpen(xpos + 1, ypos - 1)) {
                    xpos++;
                    ypos--;
                } else {
                    horizontalMove();
                }
            }
        } else if (GameFrame.x < xpos) { // if mho is left of player
            if (GameFrame.y > ypos) {
                if (checkOpen(xpos - 1, ypos + 1)) {
                    xpos--;
                    ypos++;
                } else {
                    horizontalMove();
                }
            } else if (GameFrame.y < ypos) {
                if (checkOpen(xpos - 1, ypos - 1)) {
                    xpos--;
                    ypos--;
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
        if (Math.abs(GameFrame.x - xpos) > Math.abs(GameFrame.y - ypos)) { // if vert dist greater than horiz dist
            if (GameFrame.x > xpos) { // if mho is under player
                if (checkOpen(xpos + 1, ypos)) {
                    xpos++;
                } else {
                    diagonalOntoFence();
                }
            } else if (GameFrame.x < xpos) {
                if (checkOpen(xpos - 1, ypos)){
                    xpos--; // move down
                } else {
                    diagonalOntoFence();
                }
            }
        } else if (Math.abs(GameFrame.y - ypos) > Math.abs(GameFrame.x - xpos)) { // if vert dist greater than horiz dist
            if (GameFrame.y > ypos) { // if mho is under player
                if (checkOpen(xpos , ypos+1)) {
                    ypos++;
                } else {
                    diagonalOntoFence();
                }
            } else if (GameFrame.y < ypos) {
                if (checkOpen(xpos , ypos-1)) {
                    ypos--; // move down
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
        if (GameFrame.x > xpos) {
            if (GameFrame.y > ypos) {
                if (checkFence(xpos + 1, ypos + 1) && !checkMho(xpos +1, ypos + 1)) { //Checks for fence and not Mho
                    xpos++;
                    ypos++;
                    alive = false;
                } else {
                    horizontalOntoFence();
                }
            } else if(GameFrame.y < ypos){
                if (checkFence(xpos + 1, ypos - 1) && !checkMho(xpos + 1, ypos - 1)) {
                    xpos++;
                    ypos--;
                    alive = false;
                } else {
                    horizontalOntoFence();
                }
            }
        } else if (GameFrame.x < xpos) { // if mho is left of player
            if (GameFrame.y > ypos) {
                if (checkFence(xpos - 1, ypos + 1) && !checkMho(xpos - 1, ypos + 1)) {
                    xpos--;
                    ypos++;
                    alive = false;
                } else {
                    horizontalOntoFence();
                }
            } else if (GameFrame.y < ypos) {
                if (checkFence(xpos - 1, ypos - 1) && !checkMho(xpos - 1, ypos - 1)) {
                    xpos--;
                    ypos--;
                    alive = false;
                } else {
                    horizontalOntoFence();
                }
            }
        }
    }

    private void horizontalOntoFence() {
        // Checks if Mho can move either horizontally or vertically onto a fence
        if (Math.abs(GameFrame.x - xpos) > Math.abs(GameFrame.y - ypos)) { // if vert dist greater than horiz dist
            if (GameFrame.x > xpos) { // if mho is under player
                if (checkFence(xpos + 1, ypos) && !checkMho(xpos +1, ypos)) { //Checks if there is a fence and no Mho
                    xpos++; //Moves Mho
                    alive = false; //Kills Mho
                }
            } else if (GameFrame.x < xpos) {
                if (checkFence(xpos - 1, ypos) && !checkMho(xpos - 1, ypos)){
                    xpos--; // move down
                    alive = false;
                }
            }
        } else if (Math.abs(GameFrame.y - ypos) > Math.abs(GameFrame.x - xpos)) { // if vert dist greater than horiz dist
            if (GameFrame.y > ypos) { // if mho is under player
                if (checkFence(xpos , ypos+1) && !checkMho(xpos, ypos+1)){
                    ypos++;
                    alive = false;
                }
            } else if (GameFrame.y < ypos) {
                if (checkFence(xpos , ypos-1)&& !checkMho(xpos, ypos-1)){
                    ypos--; // move down
                    alive = false;
                }
            }
        }
    }

    public boolean checkOpen(int xloc,int yloc){
        //Returns true if a that location is open
        boolean retval = true;
        if(GameFrame.objectLoc[xloc][yloc] == 1){
            retval = false;
        }
        for(int i = 0; i < GameFrame.npcLoc.length; i++){
            if(GameFrame.npcLoc[i].xpos == xloc && GameFrame.npcLoc[i].ypos == yloc){
                retval = false;
                break;
            }
        }
        return retval;
    }

    public boolean checkFence(int xloc, int yloc){
        //Return true if a fence is at that location,
        boolean retval = false;
        if(GameFrame.objectLoc[xloc][yloc] != 0){
            retval = true;
        }
        return retval;
    }

    public boolean checkMho(int xloc, int yloc){
        //Return true if an Mho is at xloc,yloc
        boolean retval = false;
        for(int i = 0; i < GameFrame.npcLoc.length; i++){
            if(GameFrame.npcLoc[i].xpos == xloc && GameFrame.npcLoc[i].ypos == yloc){
                retval = true;
                break;
            }
        }
        return retval;
    }
}
