import java.awt.*;
import javax.swing.JFrame;
import java.lang.*;
import java.util.*;

public class PhysicsFrame extends JFrame {
  /**
    Declaring Variables
  **/
  int x;
  int y = 0;
  double timeZero;
  double t;
  int numCoeff;
  int[] coefficients;
  double[] coords = new double[3];
  double[] sva;
  double timePassed;

  /**
    Initializing
  **/
  public double[] getEquations(){
		int d = 0;
		while(true){
			System.out.println("In how many dimensions is your motion?");
			Scanner dimensionScanner = new Scanner(System.in);
			d = Integer.parseInt(dimensionScanner.nextLine());
      dimensionScanner.close();
			if(d>3 || d<1){
				System.out.println(" ");System.out.println(" ");System.out.println("How?");
			} else if(d==0){
				System.out.println(" ");System.out.println(" ");System.out.println("Whats the point then?");
			} else {
        break;
      }
		}
		sva = findSVA(d);
		return sva;
	}

	public double[] findSVA(int d){
		double[] retval = new double[(d*3)+1];
		char[] dimensionChars = new char[]{'x','y','z'};
		for(int i = 0; i<d; i++){
				System.out.println("What is the original " + dimensionChars[i] + " position?");
				Scanner sScanner = new Scanner(System.in);
				retval[(3*i)] = Double.parseDouble(sScanner.nextLine())*Math.pow(-1, i);
        sScanner.close();
				System.out.println("What is the velocity along the " + dimensionChars[i] + " axis?");
				Scanner vScanner = new Scanner(System.in);
				retval[(3*i)+1] = Double.parseDouble(vScanner.nextLine())*Math.pow(-1, i);
        vScanner.close();
				System.out.println("What is the acceleration along the " + dimensionChars[i] + " axis?");
				Scanner aScanner = new Scanner(System.in);
				retval[(3*i)+2] = Double.parseDouble(aScanner.nextLine())*Math.pow(-1, i);
        aScanner.close();
        retval[retval.length-1] = System.currentTimeMillis();
		}
		return retval;
	}

  public void calcLoc(double[] sva){
    if((((System.currentTimeMillis()-sva[sva.length-1])/1000)-timePassed)>0.02){
      timePassed = (System.currentTimeMillis()-sva[sva.length-1])/1000;
  		for(int i = 0; i<(sva.length-1)/3; i++){
        double t = (System.currentTimeMillis()-sva[sva.length-1])/1000;
  			coords[i] = sva[(3*i)] + (sva[(3*i)+1]*t) + (0.5*sva[(3*i)+2]*Math.pow(t,2));
  		}
      repaint();
    } else {
    }
  }

  public PhysicsFrame() {
    setSize(800, 600);
    setBackground(Color.WHITE);
  }

  public void paint(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 10000, 10000);
    g.setColor(Color.BLUE);
    g.fillOval((int)((10*coords[0])+400) - (int)(((10*coords[2])+50)/2),(int)((10*coords[1])+300) - (int)(((10*coords[2])+50)/2), (int)((10*coords[2])+50), (int)((10*coords[2])+50));
  }
}
