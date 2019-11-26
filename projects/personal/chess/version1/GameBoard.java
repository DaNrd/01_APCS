import java.awt.*;
import javax.swing.*;

public class GameBoard extends JComponent {

    public int boardWidth = 8; // must be even
    public int boardHeight = 8; // must be even
    public int[][] boardLayout = new int[boardWidth][boardHeight];
    public int numRook = 2; // must be even
    public int numKnight = 2; // must be even
    public int numBishop = 2; // must be even
    public int scale;

    public void updateFrameSize() {
        if (getWidth() > getHeight()) {
            scale = getHeight() / (boardHeight+2);
        } else {
            scale = getWidth() / (boardWidth+2);
        }
    }

    public void init() {
        clearBoard();
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
                boardLayout[i][j] = 0;
            }
        }
    }

    public void spawnPawns() {
        for (int i = 0; i < boardWidth; i++) {
            boardLayout[i][1] = 11; // black
            boardLayout[i][boardHeight - 2] = 1; // white
        }
    }

    public void spawnRooks() {
        for (int i = 0; i < numRook / 2; i++) { // far left
            boardLayout[i][0] = 22; // black
            boardLayout[i][boardHeight - 1] = 2; // white
        }
        for (int i = 0; i < numRook / 2; i++) { // far right
            boardLayout[boardWidth - i - 1][0] = 22; // black
            boardLayout[boardWidth - i - 1][boardHeight - 1] = 2; // white
        }
    }

    public void spawnKnights() {
        for (int i = 0; i < numKnight / 2; i++) { // far left
            boardLayout[i + (numRook / 2)][0] = 33; // black
            boardLayout[i + (numRook / 2)][boardHeight - 1] = 3; // white
        }
        for (int i = 0; i < numKnight / 2; i++) { // far right
            boardLayout[boardWidth - (i + 1 + (numRook / 2))][0] = 33; // black
            boardLayout[boardWidth - (i + 1 + (numRook / 2))][boardHeight - 1] = 3; // white
        }
    }

    public void spawnBishops() {
        for (int i = 0; i < numBishop / 2; i++) { // far left
            boardLayout[i + (numRook / 2) + (numKnight / 2)][0] = 44; // black
            boardLayout[i + (numRook / 2) + (numKnight / 2)][boardHeight - 1] = 4; // white
        }
        for (int i = 0; i < numBishop / 2; i++) { // far right
            boardLayout[boardWidth - (i + 1 + (numRook / 2) + (numKnight / 2))][0] = 44; // black
            boardLayout[boardWidth - (i + 1 + (numRook / 2) + (numKnight / 2))][boardHeight - 1] = 4; // white
        }
    }

    public void spawnKings() {
        boardLayout[(boardWidth / 2)][0] = 55; // black
        boardLayout[(boardWidth / 2)][boardHeight - 1] = 5; // white
    }

    public void spawnQueens() {
        boardLayout[(boardWidth / 2) - 1][0] = 66; // black
        boardLayout[(boardWidth / 2) - 1][boardHeight - 1] = 6; // white
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawCheckers(g);
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if ((boardLayout[i][j] % 10) == 1) {
                    drawPawn(g, i, j);
                }
                if ((boardLayout[i][j] % 10) == 2) {
                    drawRook(g, i, j);
                }
                if ((boardLayout[i][j] % 10) == 3) {
                    drawKnight(g, i, j);
                }
                if ((boardLayout[i][j] % 10) == 4) {
                    drawBishop(g, i, j);
                }
                if ((boardLayout[i][j] % 10) == 5) {
                    drawKing(g, i, j);
                }
                if ((boardLayout[i][j] % 10) == 6) {
                    drawQueen(g, i, j);
                }
            }
        }
    }

    public void drawBackground(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,scale * scale, scale * scale);
    }

    public void drawCheckers(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(scale, scale, scale * boardWidth, scale * boardHeight);
        for (int i = 0; i < boardWidth / 2; i++) { // black squares
            for (int j = 0; j < boardHeight / 2; j++) {
                g.setColor(Color.BLACK);
                g.fillRect(scale * (2 * i + 1), scale * (2 * j + 1), scale, scale);
                g.fillRect(scale * (2 * i + 2), scale * (2 * j + 2), scale, scale);
            }
        }
    }

    public void drawPawn(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 1){
            g.setColor(Color.blue);
        } else if (boardLayout[i][j] == 11) {
            g.setColor(Color.cyan);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawRook(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 2){
            g.setColor(Color.darkGray);
        } else if (boardLayout[i][j] == 22) {
            g.setColor(Color.gray);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawKnight(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 3){
            g.setColor(Color.green);
        } else if (boardLayout[i][j] == 33) {
            g.setColor(Color.magenta);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawBishop(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 4){
            g.setColor(Color.red);
        } else if (boardLayout[i][j] == 44) {
            g.setColor(Color.pink);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawKing(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 5){
            g.setColor(Color.yellow);
        } else if (boardLayout[i][j] == 55) {
            g.setColor(Color.yellow);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }

    public void drawQueen(Graphics g, int i, int j) {
        if (boardLayout[i][j] == 6){
            g.setColor(Color.orange);
        } else if (boardLayout[i][j] == 66) {
            g.setColor(Color.orange);
        }
        g.fillOval(scale * (i + 1), scale * (j + 1), scale, scale);
    }
}