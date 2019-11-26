import java.lang.*;
import java.util.*;

public class StateUpdater{
	public void calculatePosition(){
		int d = 0;
		while(true){
			System.out.println("In how many dimensions is your motion?");
			Scanner dimensionScanner = new Scanner(System.in);
			d = Integer.parseInt(dimensionScanner.nextLine());
			if(3>d && d>1){
				break;
			} else if(d>3 || d<1){
				System.out.println(" ");System.out.println(" ");System.out.println("How?");
			} else if(d==0){
				System.out.println(" ");System.out.println(" ");System.out.println("Whats the point then?");
			}
		}
		double[] sva = findSVA(d);
		System.out.println("Please input the time:");
		Scanner tScanner = new Scanner(System.in);
		double t = Double.parseDouble(tScanner.nextLine());
		double[] orderedPair = calcFinal(sva, t);
		System.out.println("At t = " + t + " seconds, the particle's position will be at (" + orderedPair[0] + "," + orderedPair[1] + "," + orderedPair[2] +  ") meters.");
	}
	public double[] findSVA(int d){
		double[] retval = new double[d*3];
		char[] dimensionChars = new char[]{'x','y','z'};
		for(int i = 0; i<d; i++){
				System.out.println("What is the original " + dimensionChars[i] + " position?");
				Scanner sScanner = new Scanner(System.in);
				retval[(3*i)] = Double.parseDouble(sScanner.nextLine());
				System.out.println("What is the velocity along the " + dimensionChars[i] + " axis?");
				Scanner vScanner = new Scanner(System.in);
				retval[(3*i)+1] = Double.parseDouble(vScanner.nextLine());
				System.out.println("What is the acceleration along the " + dimensionChars[i] + " axis?");
				Scanner aScanner = new Scanner(System.in);
				retval[(3*i)+2] = Double.parseDouble(aScanner.nextLine());
		}
		return retval;
	}
	public double[] calcFinal(double[] sva, double t){
		double[] retval = new double[3];
		for(int i = 0; i<sva.length/3; i++){
			retval[i] = sva[(3*i)] + (sva[(3*i)+1]*t) + (0.5*sva[(3*i)+2]*Math.pow(t,2));
		}
		return retval;
	}
}
