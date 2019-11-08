import java.util.ArrayList;
import java.util.Collections;

public class Player extends MovePiece {
    PositionList listOfPotentialPositions = new PositionList();

    public Player(){
        alive = true;
    }

    public void initPlayer(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void stay() {
    }

    public void getListPotentialPositions(){ //all possible jump positions (onto mho or onto open space)
        listOfPotentialPositions.clear();
        for (int a = 0; a < GameFrame.boardWidth; a++) {
            for (int b = 0; b < GameFrame.boardHeight; b++) {
                if(!(objectLocations[a][b] instanceof Fence)){
                    listOfPotentialPositions.add(new Position(a,b));
                }
            }
        }
        listOfPotentialPositions.shuffle(); //shuffles the positions so that they are in random order
    }

    public BoardPiece[][] jump(BoardPiece[][] objectLocationsForJump) { // moves player randomly but never on to fence
        this.objectLocations = objectLocationsForJump;
        getListPotentialPositions();
        objectLocationsForJump[x][y] = new BlankSpace();
        initPlayer(listOfPotentialPositions.get(0).x, listOfPotentialPositions.get(0).y);
        checkIfAlive(objectLocationsForJump);
        objectLocationsForJump[x][y] = this;
        return objectLocationsForJump;
    }

    public void checkIfAlive(BoardPiece[][] objectLocations){
        if(objectLocations[x][y] instanceof Fence || objectLocations[x][y] instanceof Mho){
            alive = false;
        }
    }
}
