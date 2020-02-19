public class MyComplexApp {
    public static void main(String[] args) {
        MyComplex c1 = new MyComplex(1.1,2.2);
        MyComplex c2 = new MyComplex(3.3,4.4);

        System.out.println("Number 1 is: " + c1);
        System.out.print(c1 + " is ");
        if(!c1.isReal()){
            System.out.print("NOT ");
        }
        System.out.println("a pure real number");
        System.out.print(c1 + " is ");
        if(!c1.isImaginary()){
            System.out.print("NOT ");
        }
        System.out.println("a pure imaginary number");
        System.out.println("");

        System.out.println("Number 2 is: " + c2);
        System.out.print(c2 + " is ");
        if(!c1.isReal()){
            System.out.print("NOT ");
        }
        System.out.println("a pure real number");
        System.out.print(c2 + " is ");
        if(!c1.isImaginary()){
            System.out.print("NOT ");
        }
        System.out.println("a pure imaginary number");
        System.out.println("");

        System.out.print(c1 + " is ");
        if(!c1.equals(c2)) {
            System.out.print("NOT ");
        }
        System.out.println("equal to " + c2);

        System.out.println(c1 + " + " + c2 + " = " + c1.addNew(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtractNew(c2));
    }
}