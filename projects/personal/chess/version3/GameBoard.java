import java.awt.*;
import javax.swing.*;

public class GameBoard extends JComponent {

    public int boardWidth = 8; // must be even
    public int boardHeight = 8; // must be even
    public int[][][] boardLayout = new int[boardWidth][boardHeight][3];
    public int numRook = 2; // must be even
    public int numKnight = 2; // must be even
    public int numBishop = 2; // must be even
    public int scale;
    public boolean player1Move = true; // to determine who's turn it is
    public boolean player1select = false;
    public boolean player2select = false;

    public void updateFrameSize() {
        if (getWidth() > getHeight()) {
            scale = getHeight() / (boardHeight+2);
        } else {
            scale = getWidth() / (boardWidth+2);
        }
    }

    public void init() {
        clearBoard();
        clearTiles();
        setupBoard();
        repaint();
    }

    public void setupBoard() {
        spawnPawns(); // value = 1 or 11
        spawnRooks(); // value = 2 or 22
        spawnKnights(); // value = 3 or 33
        spawnBishops(); // value = 4 or 44
        spawnKings(); // value = 5 or 55
        spawnQueens(); // value = 6 or 66
    }

    public void clearBoard() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                for (int k = 0; k < 3; k++) {
                    boardLayout[i][j][k] = 0;
                }
            }
        }
    }

    public void clearTiles() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                boardLayout[i][j][0] = 0;
            }
        }
    }

    public void spawnPawns() {
        for (int i = 0; i < boardWidth; i++) {
            boardLayout[i][1][2] = 1; // black
            boardLayout[i][boardHeight - 2][1] = 1; // white
        }
    }

    public void spawnRooks() {
        for (int i = 0; i < numRook / 2; i++) { // far left
            boardLayout[i][0][2] = 2; // black
            boardLayout[i][boardHeight - 1][1] = 2; // white
        }
        for (int i = 0; i < numRook / 2; i++) { // far right
            boardLayout[boardWidth - i - 1][0][2] = 2; // black
            boardLayout[boardWidth - i - 1][boardHeight - 1][1] = 2; // white
        }
    }

    public void spawnKnights() {
        for (int i = 0; i < numKnight / 2; i++) { // far left
            boardLayout[i + (numRook / 2)][0][2] = 3; // black
            boardLayout[i + (numRook / 2)][boardHeight - 1][1] = 3; // white
        }
        for (int i = 0; i < numKnight / 2; i++) { // far right
            boardLayout[boardWidth - (i + 1 + (numRook / 2))][0][2] = 3; // black
            boardLayout[boardWidth - (i + 1 + (numRook / 2))][boardHeight - 1][1] = 3; // white
        }
    }

    public void spawnBishops() {
        for (int i = 0; i < numBishop / 2; i++) { // far left
            boardLayout[i + (numRook / 2) + (numKnight / 2)][0][2] = 4; // black
            boardLayout[i + (numRook / 2) + (numKnight / 2)][boardHeight - 1][1] = 4; // white
        }
        for (int i = 0; i < numBishop / 2; i++) { // far right
            boardLayout[boardWidth - (i + 1 + (numRook / 2) + (numKnight / 2))][0][2] = 4; // black
            boardLayout[boardWidth - (i + 1 + (numRook / 2) + (numKnight / 2))][boardHeight - 1][1] = 4; // white
        }
    }

    public void spawnKings() {
        boardLayout[(boardWidth / 2)][0][2] = 5; // black
        boardLayout[(boardWidth / 2)][boardHeight - 1][1] = 5; // white
    }

    public void spawnQueens() {
        boardLayout[(boardWidth / 2) - 1][0][2] = 6; // black
        boardLayout[(boardWidth / 2) - 1][boardHeight - 1][1] = 6; // white
    }

    public void tileClicked(int x, int y) {
        int team = 1;
        if(player1Move == false) {
            team = 2;
        }
        if(boardLayout[x][y][team] != 0) {
            clearTiles();
            showPossibleMoves(x,y,team);
        } else if(boardLayout[x][y][0] == team) {
            for(int i = 0; i < boardWidth; i++){
                for(int j = 0; j < boardHeight; j++){
                    if(boardLayout[i][j][0] == 11*team) {
                        boardLayout[x][y][team] = boardLayout[i][j][team];
                        boardLayout[i][j][team] = 0;
                        boardLayout[x][y][3 - team] = 0;
                        player1Move = !player1Move;
                    }
                }
            }
            clearTiles();
        }
        repaint();
    }

    public boolean existsBetween(int value, int max, int min) {
        boolean retval = false;
        if(value >= min && value <= max){
            retval = true;
        }
        return retval;
    }

    public boolean checkEmpty(int x, int y) {
        boolean retval = true;
        if((boardLayout[x][y][1] != 0) || (boardLayout[x][y][2] != 0)) {
            retval = false;
        }
        return retval;
    }

    public void setTilePossible(int x, int y, int team){
        if(boardLayout[x][y][team] == 0) {
            if(team == 1){
                boardLayout[x][y][0] = 1;
            } else if(team == 2) {
                boardLayout[x][y][0] = 2;
            }
        }
    }

    public void showPossibleMoves(int x, int y, int team) {
        if(boardLayout[x][y][team] == 1) {
            possiblePawnMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 2) {
            possibleRookMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 3) {
            possibleKnightMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 4) {
            possibleBishopMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 5) {
            possibleKingMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 6) {
            possibleRookMoves(x,y,team);
            possibleBishopMoves(x,y,team);
        }
        repaint();
    }

    public void possiblePawnMoves(int x, int y, int team) {
        if(team == 1) {
            if(existsBetween(y - 1, 7, 0)) {
                if(existsBetween(x - 1, 7, 0)) {
                    if(boardLayout[x - 1][y - 1][2] != 0) {
                        setTilePossible(x - 1, y - 1, team);
                    }
                }
                if(existsBetween(x + 1, 7, 0)) {
                    if(boardLayout[x + 1][y - 1][2] != 0) {
                        setTilePossible(x + 1, y - 1, team);
                    }
                }
            }
            if(checkEmpty(x,y - 1)) {
                setTilePossible(x, y - 1, team);
                if(checkEmpty(x,y - 2) && y == 6) {
                    setTilePossible(x , y - 2, team);
                }
            }
        } else if(team == 2) {
            if(existsBetween(y + 1, 7, 0)) {
                if(existsBetween(x - 1, 7, 0)) {
                    if(boardLayout[x - 1][y + 1][1] != 0) {
                        setTilePossible(x - 1, y + 1, team);
                    }
                }
                if(existsBetween(x + 1, 7, 0)) {
                    if(boardLayout[x + 1][y + 1][1] != 0) {
                        setTilePossible(x + 1, y + 1, team);
                    }
                }
            }
            if(checkEmpty(x,y + 1)) {
                setTilePossible(x, y + 1, team);
                if (checkEmpty(x, y + 2) && y == 1) {
                    setTilePossible(x, y + 2, team);
                }
            }
        }
        boardLayout[x][y][0] = 11*team;
    }

    public void possibleRookMoves(int x, int y, int team) {
        for(int i = x; i < 7; i++) {
            if(boardLayout[i][y][team] != 0 && i != x) {
                break;
            }
            setTilePossible(i, y, team);
            if(boardLayout[i][y][3-team] != 0) {
                break;
            }
        }
        for(int i = x; i > 0; i--) {
            if(boardLayout[i][y][team] != 0 && i != x) {
                break;
            }
            setTilePossible(i, y, team);
            if(boardLayout[i][y][3-team] != 0) {
                break;
            }
        }
        for(int i = y; i < 7; i++) {
            if(boardLayout[x][i][team] != 0 && i != y) {
                break;
            }
            setTilePossible(x, i, team);
            if(boardLayout[x][i][3-team] != 0) {
                break;
            }
        }
        for(int i = y; i > 0; i--) {
            if(boardLayout[x][i][team] != 0 && i != y) {
                break;
            }
            setTilePossible(x, i, team);
            if(boardLayout[x][i][3-team] != 0) {
                break;
            }
        }
        boardLayout[x][y][0] = 11*team;
    }

    public void possibleKnightMoves(int x, int y, int team) {
        if(existsBetween(x + 2, 7, 0)) {
            if(existsBetween(y - 1, 7, 0)) {
                if(checkEmpty(x + 2, y - 1) || boardLayout[x + 2][y - 1][3 - team] != 0) {
                    setTilePossible(x + 2, y - 1, team);
                }
            }
            if(existsBetween(y + 1, 7, 0)) {
                if(checkEmpty(x + 2, y + 1) || boardLayout[x + 2][y + 1][3 - team] != 0) {
                    setTilePossible(x + 2, y + 1, team);
                }
            }
        }
        if(existsBetween(x - 2, 7, 0)) {
            if(existsBetween(y - 1, 7, 0)) {
                if(checkEmpty(x - 2, y - 1) || boardLayout[x - 2][y - 1][3 - team] != 0) {
                    setTilePossible(x - 2, y - 1, team);
                }
            }
            if(existsBetween(y + 1, 7, 0)) {
                if(checkEmpty(x - 2, y + 1) || boardLayout[x - 2][y + 1][3 - team] != 0) {
                    setTilePossible(x - 2, y + 1, team);
                }
            }
        }
        if(existsBetween(y + 2, 7, 0)) {
            if(existsBetween(x - 1, 7, 0)) {
                if(checkEmpty(x - 1, y + 2) || boardLayout[x - 1][y + 2][3 - team] != 0) {
                    setTilePossible(x - 1, y + 2, team);
                }
            }
            if(existsBetween(x + 1, 7, 0)) {
                if(checkEmpty(x + 1, y + 2) || boardLayout[x + 1][y + 2][3 - team] != 0) {
                    setTilePossible(x + 1, y + 2, team);
                }
            }
        }
        if(existsBetween(y - 2, 7, 0)) {
            if(existsBetween(x - 1, 7, 0)) {
                if(checkEmpty(x - 1, y - 2) || boardLayout[x - 1][y - 2][3 - team] != 0) {
                    setTilePossible(x - 1, y - 2, team);
                }
            }
            if(existsBetween(x + 1, 7, 0)) {
                if(checkEmpty(x + 1, y - 2) || boardLayout[x + 1][y - 2][3 - team] != 0) {
                    setTilePossible(x + 1, y - 2, team);
                }
            }
        }
        boardLayout[x][y][0] = 11*team;
    }

    public void possibleBishopMoves(int x, int y, int team) {
        for(int i = 1; i<8; i++) {
            if (existsBetween(x - i, 7, 0) && existsBetween(y - i, 7, 0)) {
                if(boardLayout[x - i][y - i][team] != 0) {
                    break;
                }
                setTilePossible(x - i, y - i, team);
                if(boardLayout[x - i][y - i][3-team] != 0) {
                    break;
                }
            }
        }
        for(int i = 1; i<8; i++) {
            if(existsBetween(x - i, 7, 0) && existsBetween(y + i, 7, 0)) {
                if(boardLayout[x - i][y + i][team] != 0) {
                    break;
                }
                setTilePossible(x - i, y + i, team);
                if(boardLayout[x - i][y + i][3-team] != 0) {
                    break;
                }
            }
        }
        for(int i = 1; i<8; i++) {
            if (existsBetween(x + i, 7, 0) && existsBetween(y - i, 7, 0)) {
                if(boardLayout[x + i][y - i][team] != 0) {
                    break;
                }
                setTilePossible(x + i, y = i, team);
                if(boardLayout[x + i][y - i][3-team] != 0) {
                    break;
                }
            }
        }
        for(int i = 1; i<8; i++) {
            if (existsBetween(x + i, 7, 0) && existsBetween(y + i, 7, 0)) {
                if(boardLayout[x + i][y + i][team] != 0) {
                    break;
                }
                setTilePossible(x + i, y + i, team);
                if(boardLayout[x + i][y + i][3-team] != 0) {
                    break;
                }
            }
        }
        boardLayout[x][y][0] = 11*team;
    }

    public void possibleKingMoves(int x, int y, int team) {
        if(existsBetween(x - 1, 7, 0)){
            if(existsBetween(y - 1, 7, 0)) {
                setTilePossible(x - 1, y - 1, team);
                setTilePossible(x, y - 1, team);
            }
            if(existsBetween(y + 1, 7, 0)) {
                setTilePossible(x - 1, y + 1 , team);
                setTilePossible(x, y + 1, team);
            }
            setTilePossible(x - 1, y, team);
        }
        if(existsBetween(x + 1, 7, 0)) {
            if (existsBetween(y - 1, 7, 0)) {
                setTilePossible(x + 1, y - 1, team);
            }
            if (existsBetween(y + 1, 7, 0)) {
                setTilePossible(x + 1, y + 1, team);
            }
            setTilePossible(x + 1, y, team);
        }
        boardLayout[x][y][0] = 11*team;
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawTiles(g);
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                for (int k = 1; k < 3; k++) {
                    g.setColor(Color.gray);
                    if (k == 2) {
                        g.setColor(Color.darkGray);
                    }
                    if (boardLayout[i][j][k] == 1) {
                        drawPawn(g, i, j);
                    }
                    if (boardLayout[i][j][k] == 2) {
                        drawRook(g, i, j);
                    }
                    if (boardLayout[i][j][k] == 3) {
                        drawKnight(g, i, j);
                    }
                    if (boardLayout[i][j][k] == 4) {
                        drawBishop(g, i, j);
                    }
                    if (boardLayout[i][j][k] == 5) {
                        drawKing(g, i, j);
                    }
                    if (boardLayout[i][j][k] == 6) {
                        drawQueen(g, i, j);
                    }
                }
            }
        }
    }

    public void drawBackground(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,scale * scale, scale * scale);
    }

    public void drawTiles(Graphics g) { // draws checkerboard
        g.setColor(Color.WHITE);
        g.fillRect(scale, scale, scale * boardWidth, scale * boardHeight);
        for (int i = 0; i < boardWidth / 2; i++) { // black squares
            for (int j = 0; j < boardHeight / 2; j++) {
                g.setColor(Color.BLACK);
                g.fillRect(scale * (2 * i + 1), scale * (2 * j + 1), scale, scale);
                g.fillRect(scale * (2 * i + 2), scale * (2 * j + 2), scale, scale);
            }
        }
        for (int i = 0; i < boardWidth; i++) { // draws possible moves
            for (int j = 0; j < boardHeight; j++) {
                if(boardLayout[i][j][0] == 1){
                    g.setColor(Color.cyan);
                    g.fillRect(scale * (i + 1), scale * (j + 1), scale, scale);
                }
                if(boardLayout[i][j][0] == 11){
                    g.setColor(Color.blue);
                    g.fillRect(scale * (i + 1), scale * (j + 1), scale, scale);
                }
                if(boardLayout[i][j][0] == 2){
                    g.setColor(Color.orange);
                    g.fillRect(scale * (i + 1), scale * (j + 1), scale, scale);
                }
                if(boardLayout[i][j][0] == 22){
                    g.setColor(Color.red);
                    g.fillRect(scale * (i + 1), scale * (j + 1), scale, scale);
                }
            }
        }
    }

    public void drawPawn(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawRook(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawKnight(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawBishop(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawKing(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawQueen(Graphics g, int i, int j) {
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }
}