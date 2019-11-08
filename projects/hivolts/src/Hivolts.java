import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Hivolts extends JFrame implements KeyListener, ActionListener { // written by aaron
    private GameFrame draw;
    private Timer animTimer = new Timer(1000, this);


    @Override
    public void actionPerformed(ActionEvent e) { // runs every timer completion
        draw.timerAction();
        draw.repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) { // records keystrokes
        if (draw.titleScreen == true) {
            draw.titleScreen = false;
            if (e.getKeyCode() == KeyEvent.VK_C) {
                draw.creditsScreen = true;
                draw.repaint();
            } else {
                draw.storyScreen = true;
                draw.init();
                draw.repaint();
            }
        } else if (draw.storyScreen == true) {
            draw.storyScreen = false;
            draw.controlsScreen = true;
            draw.repaint();
        } else if (draw.controlsScreen == true) {
            draw.controlsScreen = false;
            draw.repaint();
        }else if (draw.roundOver == true) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                draw.titleScreen = true;
                draw.roundOver = false;
                draw.repaint();
            } else {
                draw.init();
                draw.repaint();
            }
        } else if(draw.creditsScreen == true) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                draw.creditsScreen = false;
                draw.titleScreen = true;
                draw.repaint();
            }
        } else {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    draw.playerDirection = 1;
                    draw.playerInstance.moveRight(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    draw.playerDirection = 2;
                    draw.playerInstance.moveLeft(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_X) {
                    draw.playerDirection = 0;
                    draw.playerInstance.moveDown(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    draw.playerDirection = 3;
                    draw.playerInstance.moveUp(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                    draw.playerDirection = 2;
                    draw.playerInstance.moveUpLeft(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    draw.playerDirection = 1;
                    draw.playerInstance.moveUpRight(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                    draw.playerDirection = 2;
                    draw.playerInstance.moveDownLeft(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    draw.playerDirection = 1;
                    draw.playerInstance.moveDownRight(draw.objectLocations);
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    draw.playerDirection = 0;
                    draw.playerInstance.stay();
                    draw.updateGameState();
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    draw.playerDirection = 0;
                    draw.objectLocations = draw.playerInstance.jump(draw.objectLocations);
                    draw.setMessage();
                    draw.repaint();
                }
                draw.moveCount++; //Adds to moveCount
            }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            draw.toggleMusic();
        }
    }

    public Hivolts() {
        this.draw = new GameFrame();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                draw.updateFrameSize();
            }
        });
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        Hivolts frame = new Hivolts();
        frame.animTimer.start();
        frame.initializeHivolts();
    }

    private void initializeHivolts() {
        this.setTitle("HiVolts");
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int size;
        if (dim.width < dim.height) {
            size = dim.width;
        } else {
            size = dim.height;
        }
        this.setSize(size, size);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setMinimumSize(new Dimension(400, 480));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(this.draw);
        this.setVisible(true);
        this.repaint();
        this.draw.playThemeMusic();
    }
}

