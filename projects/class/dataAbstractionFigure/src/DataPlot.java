import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import java.util.Random;

public class DataPlot extends JFrame {

  private int width;
  private int height;
  private HashMap<String,StateFigures> data; // stateName, StateFigures
  private HashMap<String,Color> colors;
  private Random rand;

  public DataPlot() {
    this.data = new HashMap<String,StateFigures>();
    this.colors = new HashMap<String,Color>();
    this.rand = new Random();
    this.width = 1000;
    this.height = 1000;
    setSize(this.width, this.height);
    setBackground(Color.WHITE);
    repaint();
  }

  public void paint(Graphics g) {
    data.forEach((k, v) -> {
      paintStates(v, g);
    });
  }

  private void paintStates(StateFigures state, Graphics g) {
    Color c = getColor(state.getState());
    g.setColor(c);
    for(Figure fig: state.getFigures()) {
      int x = fig.getDate();
      int y = fig.getNumVirusCases();
      g.fillOval(x*6, 500 - y/20,  10, 10);
    }
  }

  public void paintStateCases(StateFigures state) {
    data.put(state.getState(), state);
    repaint();
  }

  private Color getColor(String name) {
    if(colors.get(name) != null) {
      return colors.get(name);
    } else {
      return getRandColor(name);
    }
  }

  private Color getRandColor(String name) {
    float red = rand.nextFloat();
    float green = rand.nextFloat();
    float blue = rand.nextFloat();
    this.colors.put(name,new Color(red,green,blue));
    return colors.get(name);
  }
}
