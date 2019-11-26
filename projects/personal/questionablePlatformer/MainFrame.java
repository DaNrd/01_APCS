import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class MainFrame extends JFrame implements KeyListener{
    private CharacterFrame draw;

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            draw.moveRight();
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            draw.moveLeft();
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            draw.moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            draw.moveUp();

    }
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    public MainFrame(){
        this.draw=new CharacterFrame();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setTitle("Square Move Practice");
                frame.setResizable(false);
                frame.setSize(600, 600);
                frame.setMinimumSize(new Dimension(600, 600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
