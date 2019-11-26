import java.awt.*;
import javax.swing.JFrame;

public class CharacterFrame extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e); // used for cow's nose
  private final Color OFFWHITE = new Color(0xdddddd); // use for cow's body
	public int x = 50;
	public int y = 50;
	public int cowWidth = 300;

	// public CharacterFrame() {
  //   init();
  // }
	//
	// public void init() {
  //   setSize(700, 400);
  //   setBackground(Color.WHITE);
  //   repaint();
  // }

	public void moveRight() {
			x = x + 5;
			repaint();
	}

	public void moveLeft() {
			x = x - 5;
			repaint();
	}

	public void moveDown() {
			y = y + 5;
			repaint();
	}

	public void moveUp() {
			y = y - 5;
			repaint();
	}

	public int cowVal(int a){
		return (int)(cowWidth * (a/300));
	}

	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		// cow tail
    g.setColor(OFFWHITE); // cow color
    g.fillOval(350, 150, cowVal(75), cowVal(100)); // cow tail
    g.setColor(Color.WHITE); // cow tail cover color
    g.fillOval(340, 160, cowVal(65), cowVal(100)); // cow tail

    // cow
    g.setColor(Color.BLACK); // cow features color
    g.fillRect(175, 200, cowVal(15), cowVal(150)); // front left leg
    g.fillRect(195, 200, cowVal(10), cowVal(130)); // front right leg
    g.fillRect(300, 200, cowVal(15), cowVal(150)); // back left leg
    g.fillRect(320, 200, cowVal(10), cowVal(130)); // back right leg

    // cow
    g.setColor(OFFWHITE); // cow color
    g.fillOval(100, 100, cowVal(300), cowVal(200)); // cow main body
    g.fillOval(50, 75, cowVal(150), cowVal(150)); // cow head
    g.fillOval(50, 75, cowVal(50), cowVal(25)); // cow ear right
    g.fillOval(150, 75, cowVal(50), cowVal(25)); // cow ear left
    // cow nose
    g.setColor(BISQUE); // cow nose color
    g.fillOval(50, 150, cowVal(150), cowVal(100)); // cow nose

    // cow features continued
    g.setColor(Color.BLACK); // cow features color
    g.fillOval(75, 200, cowVal(40), cowVal(25)); // cow nostral right
    g.fillOval(140, 200, cowVal(40), cowVal(25)); // cow nostral left
    g.fillOval(85, 100, cowVal(25), cowVal(25)); // cow eye right
    g.fillOval(130, 100, cowVal(25), cowVal(25)); // cow eye left
    g.fillOval(200, 150, cowVal(100), cowVal(40)); // cow spot left
    g.fillOval(220, 230, cowVal(100), cowVal(40)); // cow spot right
    g.fillOval(290, 180, cowVal(100), cowVal(40)); // cow spot bottom

	}
}
