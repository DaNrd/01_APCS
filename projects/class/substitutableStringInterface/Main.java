import java.util.*;
public class Main{
	public static void main(String[] args){
		Interface i = new Interface();
		System.out.println("Which function would you like to use, type 1 for extractFirstParen() or 2 for substituteAll()");
		Scanner fScanner = new Scanner(System.in);
		int f = Integer.parseInt(fScanner.nextLine());
		if(f == 1){
			System.out.println("What is your sentance?");
			Scanner aScanner = new Scanner(System.in);
			String a = aScanner.nextLine();
			i.extractFirstParen(a);
			aScanner.close();
		} else if(f == 2){
			System.out.println("What is your sentance?");
			Scanner aScanner = new Scanner(System.in);
			String a = aScanner.nextLine();
			System.out.println("What should be replaced?");
			Scanner bScanner = new Scanner(System.in);
			String b = aScanner.nextLine();
			System.out.println("What should " + '"' + b + '"' + " be replaced with?");
			Scanner cScanner = new Scanner(System.in);
			String c = aScanner.nextLine();
			aScanner.close();
			bScanner.close();
			cScanner.close();
			i.substituteAll(a, b, c);
		} else {
			System.out.println("invalid option");
		}
	}
}
