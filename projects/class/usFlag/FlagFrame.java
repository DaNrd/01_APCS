import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FlagFrame extends JFrame {
  /**
    Declaring Variables
  **/
  // colors
  private final Color OLDGLORYRED = new Color(0xbf1238);
  private final Color OLDGLORYBLUE = new Color(0x002147);
  // overall
  double scale;
  // star
  int numPoints = 5; // number of outer points
  double theta = (180/numPoints); // 1/2 of *traditional* theta for easier use
  int truePoints = 2*numPoints; // number of total points (outer and inner)

  /**
    Initializing
  **/
  public FlagFrame() {
    init();
  }

  /**
    Defining the background
  **/
  public void init() {
    setSize((int) ((400*1.6)+0.5), 400);
    setBackground(Color.BLACK);
    updateFrameSize();
    repaint();
    // runs updateFrameSize() when window is resized
    getContentPane().addComponentListener(new ComponentAdapter(){
      public void componentResized(ComponentEvent e) {
        updateFrameSize();
      }
    });
  }

  public void updateFrameSize() {
    // determines whether to use height or width as the scale facter (for biggest proportional flag)
    if(getWidth()>1.9*getHeight()){
      scale = getHeight();
    } else {
      scale = getWidth()/1.9;
    }
  }
  //calculates the x position of the points for each star
  public int[] starX(int x) {
    double starRadius = ((0.5 * scale * 0.0616));
    double starInnerRadius = 0.5*starRadius*Math.sin(Math.toRadians(theta))/Math.sin(Math.toRadians(180-(theta+theta/2))); // this calc uses law of sines
    int[] xPoints = new int[truePoints];
    for(int m=0; m<(numPoints); m++){
      xPoints[2*m] = (int) (x - (starRadius*Math.sin(2*m*Math.toRadians(theta))));
      xPoints[(2*m)+1] = (int) (x - (starInnerRadius*Math.sin(((2*m)+1)*Math.toRadians(theta))));
    }
    return xPoints;
  }
  //calculates the y position of the points for each star
  public int[] starY(int y) {
    double starRadius = ((0.5 * scale * 0.0616));
    double starInnerRadius = 0.5*starRadius*Math.sin(Math.toRadians(theta))/Math.sin(Math.toRadians(180-(theta+theta/2))); // this calc uses law of sines
    int[] yPoints = new int[truePoints];
    for(int m=0; m<(numPoints); m++){
      yPoints[2*m] = (int) (y - (starRadius*Math.cos(2*m*Math.toRadians(theta))));
      yPoints[(2*m)+1] = (int) (y - (starInnerRadius*Math.cos(((2*m)+1)*Math.toRadians(theta))));
    }
    return yPoints;
  }
  /**
    Drawing the flag
  **/
  public void paint(Graphics g) {
    // defining the variables in terms of scale (for scalability)
    int unionFly = (int) ((0.76 * scale)+0.5);
    int unionHoist = (int) ((0.5389 * scale)+0.5);
    int hoist = (int) ((scale)+0.5);
    int fly = (int) ((1.9 * scale)+0.5);
    int stripeHoist = (int) ((0.0769 * scale)+0.5);
    int starHorzBorder = (int) ((0.063 * scale)+0.5);
    int starVertBorder = (int) ((0.054 * scale)+0.5);

    // stripes
    g.setColor(Color.WHITE);
    for(int i=0;i<6; i++){
      g.fillRect(0, stripeHoist*((2*i)+1), fly, stripeHoist);
    }
    g.setColor(OLDGLORYRED);
    for(int i=0;i<7; i++){
      g.fillRect(0, stripeHoist*((2*i)), fly, stripeHoist);
    }
    // hoist
    g.setColor(OLDGLORYBLUE);
    g.fillRect(0, 0, unionFly, unionHoist);
    // stars
    g.setColor(Color.WHITE);
    for(int i=0; i<6; i++){
      for(int n=0; n<5; n++){
        g.fillPolygon(starX(((2*i)+1)*starHorzBorder), starY(((2*n)+1)*starVertBorder), truePoints);
      }
    }
    for(int i=0; i<5; i++){
      for(int n=0; n<4; n++){
        g.fillPolygon(starX(((2*i)+2)*starHorzBorder), starY(((2*n)+2)*starVertBorder), truePoints);
      }
    }
    // some black boxes to deal with any artifacting
    g.setColor(Color.BLACK);
    g.fillRect(0, hoist, getWidth(), getHeight());
    g.fillRect(fly, 0, getWidth(), getHeight());
  }
}
