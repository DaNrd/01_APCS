import java.util.*;

public class Exponentiation{
	public static void main(String[] args){
		int tenPow = 0;
		System.out.println("Please input your base:");
		Scanner baseScanner = new Scanner(System.in);
		double base = Double.parseDouble(baseScanner.nextLine());
		if(base>0 && base<1){
			while((int)base != base){
				tenPow++;
				base = base*10;
			}
		}
		System.out.println("Please input your exponent as an integer:");
		Scanner powerScanner = new Scanner(System.in);
		int power = Integer.parseInt(powerScanner.nextLine());
		System.out.println("(" + base/calcPower(10, tenPow) + ")^(" + power + ") = " + calcPower(base, power)/calcPower(calcPower(10, tenPow), power));
		baseScanner.close();
		powerScanner.close();
	}
	public static double calcPower(double base, double power){
		if(power<0){
			return calcPower(1/base, -power);
		} else if(power == 1){
			return base;
		} else if(power == 0){
			return 1;
		} else if(power%2 == 1){
			return base*calcPower(base*base, (power-1)/2);
		} else {
			return calcPower(base*base, power/2);
		}
	}
}
