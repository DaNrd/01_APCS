import java.awt.*;
import java.lang.*;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.*;

public class SimpleChess extends JFrame implements MouseListener {
    private GameBoard draw;

    public int mouseLocX;
    public int mouseLocY;

    @Override
    public void mouseExited(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        mouseLocX = ((e.getX() - (e.getX() % draw.scale)) / draw.scale) -1;
        mouseLocY = ((e.getY() - (e.getY() % draw.scale)) / draw.scale)-1;
        if(mouseLocY >= 0 && mouseLocY <= 7 && mouseLocX >= 0 && mouseLocX <= 7) {
            draw.tileClicked(mouseLocX, mouseLocY);
        } else {
            draw.clearTiles();
            draw.repaint();
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }

    public SimpleChess() {
        this.draw = new GameBoard();
        setFocusable(true);
        getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                draw.updateFrameSize();
            }
        });
    }

    public static void main(String[] args) {
        SimpleChess frame = new SimpleChess();
        frame.initializeChess();
    }

    private void initializeChess() {
        this.setTitle("Chess");
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
        draw.init();
        this.repaint();
        draw.addMouseListener(this);
    }
}