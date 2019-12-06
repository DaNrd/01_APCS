import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
  /**
    Declaring Variables
  **/
  private final Color BISQUE = new Color(0xcdb79e); // used for cow's nose
  private final Color OFFWHITE = new Color(0xdddddd); // use for cow's body

  /**
    Initializing
  **/
  public CowFrame() {
    init();
  }

  /**
    Defining the background
  **/
  public void init() {
    setSize(700, 400);
    setBackground(Color.GREEN);
    repaint();
  }

  /**
    Drawing the Cow
  **/
  public void paint(Graphics cowDrawing) {
    // environment
    cowDrawing.setColor(Color.BLUE); // sky color
    cowDrawing.fillRect(0, 0, 10000, 260); //sky plane
    cowDrawing.setColor(Color.WHITE); //cloud color
    cowDrawing.fillOval(505, 55, 65, 65); // right cloud right ball
    cowDrawing.fillOval(475, 55, 45, 45); // right cloud left ball
    cowDrawing.fillOval(440, 85, 150, 50); // right cloud body
    cowDrawing.fillOval(285, 0, 65, 65); // left cloud right ball
    cowDrawing.fillOval(255, 15, 45, 45); // left cloud left ball
    cowDrawing.fillOval(220, -5, 150, 50); // left cloud body

    // cow tail
    cowDrawing.setColor(OFFWHITE); // cow color
    cowDrawing.fillOval(350, 150, 75, 100); // cow tail
    cowDrawing.setColor(Color.BLUE); // cow tail cover color
    cowDrawing.fillOval(340, 160, 65, 100); // cow tail

    // cow
    cowDrawing.setColor(Color.BLACK); // cow features color
    cowDrawing.fillRect(175, 200, 15, 150); // front left leg
    cowDrawing.fillRect(195, 200, 10, 130); // front right leg
    cowDrawing.fillRect(300, 200, 15, 150); // back left leg
    cowDrawing.fillRect(320, 200, 10, 130); // back right leg

    // cow
    cowDrawing.setColor(OFFWHITE); // cow color
    cowDrawing.fillOval(100, 100, 300, 200); // cow main body
    cowDrawing.fillOval(50, 75, 150, 150); // cow head
    cowDrawing.fillOval(50, 75, 50, 25); // cow ear right
    cowDrawing.fillOval(150, 75, 50, 25); // cow ear left
    // cow nose
    cowDrawing.setColor(BISQUE); // cow nose color
    cowDrawing.fillOval(50, 150, 150, 100); // cow nose

    // cow features continued
    cowDrawing.setColor(Color.BLACK); // cow features color
    cowDrawing.fillOval(75, 200, 40, 25); // cow nostral right
    cowDrawing.fillOval(140, 200, 40, 25); // cow nostral left
    cowDrawing.fillOval(85, 100, 25, 25); // cow eye right
    cowDrawing.fillOval(130, 100, 25, 25); // cow eye left
    cowDrawing.fillOval(200, 150, 100, 40); // cow spot left
    cowDrawing.fillOval(220, 230, 100, 40); // cow spot right
    cowDrawing.fillOval(290, 180, 100, 40); // cow spot bottom

    // sun
    cowDrawing.setColor(Color.YELLOW); // sun color
    cowDrawing.fillOval(600, -100, 200, 200); // sun
  }
}
