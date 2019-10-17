import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main extends JFrame implements KeyListener {
    private GameFrame draw;
    private String[] thing = {"Hey there, how's life. This value is never used so I thought I'd just say hi! :)"};

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (draw.reset == false){
          if (e.getKeyCode() == KeyEvent.VK_D) {
              draw.moveRight();
          } else if (e.getKeyCode() == KeyEvent.VK_A) {
              draw.moveLeft();
          } else if (e.getKeyCode() == KeyEvent.VK_X) {
              draw.moveDown();
          } else if (e.getKeyCode() == KeyEvent.VK_W) {
              draw.moveUp();
          }
          if (e.getKeyCode() == KeyEvent.VK_Q) {
              draw.moveUpLeft();
          } else if (e.getKeyCode() == KeyEvent.VK_E) {
              draw.moveUpRight();
          } else if (e.getKeyCode() == KeyEvent.VK_Z) {
              draw.moveDownLeft();
          } else if (e.getKeyCode() == KeyEvent.VK_C) {
              draw.moveDownRight();
          } else if (e.getKeyCode() == KeyEvent.VK_S) {
              draw.stay();
          } else if (e.getKeyCode() == KeyEvent.VK_J) {
              draw.jump();
          }
        } else {
          if(draw.alive == true){
            draw.init();
            draw.repaint();
          } else {
            main(thing);
          }
        }
    }

    public Main() {
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
        Main frame = new Main();
        frame.setTitle("HiVolts");
        frame.setSize(1000, 1000);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.draw.init();
        frame.getContentPane().add(frame.draw);
        frame.setVisible(true);
    }
}
