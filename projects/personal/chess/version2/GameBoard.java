import java.awt.*;
import javax.swing.*;

public class GameBoard extends JComponent {

    public int boardWidth = 8; // must be even
    public int boardHeight = 8; // must be even
    public int[][][] boardLayout = new int[boardWidth][boardHeight][3];
    public int[][] possibleMoves = new int[boardWidth][boardHeight];
    public int numRook = 2; // must be even
    public int numKnight = 2; // must be even
    public int numBishop = 2; // must be even
    public int scale;
    public boolean player1Move = true;

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
                possibleMoves[i][j] = 0;
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
        clearTiles();
        if(boardLayout[x][y][1] != 0) {
            int team = 1;
            showPossibleMoves(x,y,team);
        } else if(boardLayout[x][y][2] != 0) {
            int team = 2;
            showPossibleMoves(x,y,team);
        } else {
            System.out.println("empty square");
            repaint();
        }
    }

    public boolean existsBetween(int value, int max, int min) {
        boolean retval = false;
        if(value >= min && value <= max){
            retval = true;
        }
        return retval;
    }

    public void showPossibleMoves(int x, int y, int team) {
        if(boardLayout[x][y][team] == 1) {
            possiblePawnMoves(x,y,team);
        } else if(boardLayout[x][y][team] == 2) {
            possibleRookMoves(x,y);
        } else if(boardLayout[x][y][team] == 3) {
            possibleKnightMoves(x,y);
        } else if(boardLayout[x][y][team] == 4) {
            possibleBishopMoves(x,y);
        } else if(boardLayout[x][y][team] == 5) {
            possibleKingMoves(x,y);
        } else if(boardLayout[x][y][team] == 6) {
            possibleQueenMoves(x,y);
        }
        repaint();
    }

    public void possiblePawnMoves(int x, int y, int team) {
        if(team == 1) {
            possibleMoves[x][y - 1] = 99;
            if(y == 6) {
                possibleMoves[x][y - 2] = 99;
            }
        } else if(team == 2) {
            possibleMoves[x][y + 1] = 99;
            if(y == 1) {
                possibleMoves[x][y + 2] = 99;
            }
        }
        possibleMoves[x][y] = 11;
    }

    public void possibleRookMoves(int x, int y) {
        for(int i = 0; i < x; i++) {
            possibleMoves[i][y] = 99;
        }
        for(int i = 7; i > x; i--) {
            possibleMoves[i][y] = 99;
        }
        for(int i = 0; i < y; i++) {
            possibleMoves[x][i] = 99;
        }
        for(int i = 7; i > y; i--) {
            possibleMoves[x][i] = 99;
        }
        possibleMoves[x][y] = 11;
    }

    public void possibleKnightMoves(int x, int y) {
        if(existsBetween(x + 2, 7, 0)) {
            if(existsBetween(y - 1, 7, 0)) {
                possibleMoves[x + 2][y - 1] = 99;
            }
            if(existsBetween(y + 1, 7, 0)) {
                possibleMoves[x + 2][y + 1] = 99;
            }
        }
        if(existsBetween(x - 2, 7, 0)) {
            if(existsBetween(y - 1, 7, 0)) {
                possibleMoves[x - 2][y - 1] = 99;
            }
            if(existsBetween(y + 1, 7, 0)) {
                possibleMoves[x - 2][y + 1] = 99;
            }
        }
        if(existsBetween(y + 2, 7, 0)) {
            if(existsBetween(x - 1, 7, 0)) {
                possibleMoves[x - 1][y + 2] = 99;
            }
            if(existsBetween(x + 1, 7, 0)) {
                possibleMoves[x + 1][y + 2] = 99;
            }
        }
        if(existsBetween(y - 2, 7, 0)) {
            if(existsBetween(x - 1, 7, 0)) {
                possibleMoves[x - 1][y - 2] = 99;
            }
            if(existsBetween(x + 1, 7, 0)) {
                possibleMoves[x + 1][y - 2] = 99;
            }
        }
        possibleMoves[x][y] = 11;
    }

    public void possibleBishopMoves(int x, int y) {
        for(int i = 0; i<8; i++) {
            if(existsBetween(x-i, 7, 0)){
                if(existsBetween(y-i, 7, 0)) {
                    possibleMoves[x-i][y-i] = 99;
                }
                if(existsBetween(y+i, 7, 0)) {
                    possibleMoves[x-i][y+i] = 99;
                }
            }
            if(existsBetween(x+i, 7, 0)){
                if(existsBetween(y-i, 7, 0)) {
                    possibleMoves[x+i][y-i] = 99;
                }
                if(existsBetween(y+i, 7, 0)) {
                    possibleMoves[x+i][y+i] = 99;
                }
            }
        }
        possibleMoves[x][y] = 11;
    }

    public void possibleKingMoves(int x, int y) {
        if(existsBetween(x - 1, 7, 0)){
            if(existsBetween(y - 1, 7, 0)) {
                possibleMoves[x - 1][y - 1] = 99;
                possibleMoves[x][y - 1] = 99;
            }
            if(existsBetween(y + 1, 7, 0)) {
                possibleMoves[x - 1][y + 1] = 99;
                possibleMoves[x][y + 1] = 99;
            }
            possibleMoves[x - 1][y] = 99;
        }
        if(existsBetween(x + 1, 7, 0)) {
            if (existsBetween(y - 1, 7, 0)) {
                possibleMoves[x + 1][y - 1] = 99;
            }
            if (existsBetween(y + 1, 7, 0)) {
                possibleMoves[x + 1][y + 1] = 99;
            }
            possibleMoves[x + 1][y] = 99;
        }
        possibleMoves[x][y] = 11;
    }

    public void possibleQueenMoves(int x, int y) {
        for(int i = 0; i < 8; i++){
            if(existsBetween(x - i, 7, 0)){
                possibleMoves[x - i][y] = 99;
                if(existsBetween(y - i, 7, 0)) {
                    possibleMoves[x - i][y - i] = 99;
                }
                if(existsBetween(y + i, 7, 0)) {
                    possibleMoves[x - i][y + i] = 99;
                    possibleMoves[x][y + i] = 99;
                }
            }
            if(existsBetween(x + i, 7, 0)) {
                possibleMoves[x + i][y] = 99;
                if (existsBetween(y - i, 7, 0)) {
                    possibleMoves[x + i][y - i] = 99;
                }
                if (existsBetween(y + i, 7, 0)) {
                    possibleMoves[x + i][y + i] = 99;
                }
            }
            if(existsBetween(y + i, 7, 0)) {
                possibleMoves[x][y + i] = 99;
            }
            if(existsBetween(y - i, 7, 0)) {
                possibleMoves[x][y - i] = 99;
            }
        }
        possibleMoves[x][y] = 11;
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawTiles(g);
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                for (int k = 0; k < 3; k++) {
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
                if(possibleMoves[i][j] == 99){
                    g.setColor(Color.cyan);
                    g.fillRect(scale * (i + 1), scale * (j + 1), scale, scale);
                }
                if(possibleMoves[i][j] == 11){
                    g.setColor(Color.blue);
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