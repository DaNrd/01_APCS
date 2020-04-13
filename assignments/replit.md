Original Code can be found [here](https://repl.it/talk/learn/An-Introduction-to-Java/13450).

#Basics
Main Method:
```java
class Main {
   public static void main(String[] args) {
     // This is a comment
     // This will be run
     // I can make new comments below the first two
     // look at me go
     // isn't this fun
   }
 }
```
Printing:
```java
class Main {
  public static void main(String[] args) {
    System.out.println("Hello, world!");    // => 'Hello, World!'
    System.out.prinln("I can use print statements!");    // => 'I can use print statements!'
  }
}
```
Math:
```java
class Main {
   public static void main(String[] args) {
     System.out.println(2+3);  // addition
     System.out.println(2-3);  //subtraction
     System.out.println(2*3);  // multiplication
     System.out.println(2/3);  // division - rounds down
     System.out.println(3%2);  // modulus - remainder of division
     System.out.println(((12+144+20)+(3*Math.sqrt(4)))/7+(5*11)+ "="+ Math.pow(9,2)+0); // => 'A dozen, a gross, a score; plus 3*sqrt(4); all over 7 plus 5*11 is 9^2 and not a bit more'
   }
 }
```
#Variables and Datatypes
Variable Basics:
```java
class Main {
  public static void main(String[] args) {
    int num;
    num = 3;
    System.out.println(num);

    // Or, on one line
    int another_num = 3;
    System.out.println(another_num);

    // reassigning the variable
    another_num = 4;
    // then assigning one variable to another's value (for primative types)
    num = another_num;
    System.out.println(num); // => '4'
  }
}
```
Common Datatypes:
```java
class Main {
  public static void main(String[] args) {
    // integers up to 2,147,483,647
    int i = 3;
    // integers up to 9,223,372,036,854,775,807
    long l = 314159265;
    // 64-bit floating-point number
    double d = 3.1415d;
    // 32-bit floating-point number (for saving memory)
    float f = 3.14f;
    // text
    String s = "Hello, World!";
    // single character
    char c = 'a';
    // true/false
    boolean b = false;
    // there are some weird conversions you can do between datatypes
    // for example:
    i = c;
    System.out.println(i); // prints the value of c => 97
  }
}
```
Multiple Values:
```java
class Main {
  public static void main(String[] args) {
    // integer array of length 10
    int[] i = new int[10];

    // access elements with 0-based index, i.e. first element is 0, second is 1 e.t.c.
    i[0] = 1;
    i[6] = 32;


    // another way of defining arrays
    int[] i2 = {1,2,3};

    // use .length to find the length of the array
    System.out.println(i.length);
    System.out.println(i2.length);
    
    //arrays are fun
    int[] i3 = {1,2,3};
    int[] i4 = i3; // doesn't copy values but reference
    i4[1] = 4; // updates reference which affects both i3 and i4
    System.out.println("i1={"+i3[0]+","+i3[1]+","+i3[2]+"}, i2={"+i4[0]+","+i4[1]+","+i4[2]+"}");
  }
}
```
Strings:
```java
class Main {
  public static void main(String[] args) {
    char[] c = {'H','e','l','l','o'};
    String s = new String(c);
    System.out.println(s);

    // .length() is used to find the length of a String
    System.out.println(s.length());
    
    // you can also print out the char array
    System.out.println(c);
  }
}
```
ArrayLists:
```java
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    al.add('a');
    al.add(3);
    al.add("Hi there!");
    // pushes to 0 index
    al.add(0,"First");
    System.out.println(al);
    System.out.println(al.size());  // => 4

    // remove removes by index, not value
    al.remove(0);
    System.out.println(al.size());  // => 3


    // also, you can set it to only 1 datatype
    ArrayList<String> sal = new ArrayList<String>();
    sal.add("Hi");
    sal.add(34);    // fails because it is not String
    
    // it's really easy to remove all the values by just remove the 0th value over and over again
    while(al.size() >0) {
        al.remove(0);
    }
    System.out.println(al);
  }
}
```
HashMaps:
```java
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    // key is String, value is Integer
    // datatypes are different than normal
    // use Boolean, Character, Double for boolean,char,double
    HashMap<String, Integer> hm = new HashMap<String, Integer>();

    hm.put("John",23);
    hm.put("Anne",17);
    // can assign same value to multiple keys
    hm.put("Freddy",17);
    
    System.out.println(hm);
    // use get to find a specific value
    System.out.println(hm.get("Anne"));
    
    // cannot search by value; returns null
    System.out.println(hm.get(17));

    hm.remove("Anne");
    System.out.println(hm);
  }
}
```
*learned that you cannot retrieve key by value and can assign multiple keys the same value but not other way around*
#Control Flow
Comparison Operators:
```java
class Main {
  public static void main(String[] args) {
    System.out.println(1==1); // equal to
    System.out.println(2>1);  // greater than
    System.out.println(2<1);  // less than
    System.out.println(1>=1); // greater than or equal to
    System.out.println(2<=1); // less than or equal to
    System.out.println(2!=1); // not equal to
    System.out.println(!(0)); // ensures value is false
  }
}
```
Logical Operators:
```java
class Main {
  public static void main(String[] args) {
    // AND - true if both are true
    System.out.println(true && true);
    // OR - true if either are true
    System.out.println(true || false);
    // NOT - swaps true with false and vice versa
    System.out.println(!true);
    // XOR - true if either are true but not both
    System.out.println(true^false);
    System.out.println(true^true);
    
    // ensures all values are false
    System.out.println(!(false || false || false));
  }
}
```
If Statements:
```java
class Main {
  public static void main(String[] args) {

    // outputs "10 is greater than 5!"
    if (10>5) {
      System.out.println("10 is greater than 5!");
    } else {
      System.out.println("10 is not greater than 5");
    }

    int a = 10;

    // outputs "a is greater than 8"
    if (a<2) {
      System.out.println("a is less than 2");
    } else if (a<8) {
      System.out.println("a is less than 8");
    } else {
      System.out.println("a is greater than 8");
    }
    
    boolean val = true;
    // this is the same
    if(val) {
        System.out.println(false);
    } else {
        System.out.println(true);
    }
    // as this
    System.out.println(!val);
  }
}
```
For Loops:
```java
class Main {
  public static void main(String[] args) {
    // loops 10 times, incrementing i by 1 each time
    // (i++)
    for (int i=0;i<10;i++) {
      System.out.println(i);
    }
    // (i--)
    for (int i=10;i>0;i--) {
        System.out.println(i);
    }


    char[] c_array = {'a','b','c','d'};
    // loos for each item in the array
    for (char c:c_array) {
      System.out.println(c);
    }
    
    // to print backwards must use for loop with an iterator
    for (int i = c_array.length - 1; i>=0; i--) {
        System.out.println(c_array[i]);
    }

  }
}
```
While Loops:
```java
class Main {
  public static void main(String[] args) {
    int x = 3;

    // continues until x=6
    // because then 6*4 == 24
    while ((x*4)!=24) {
      System.out.println(x);
      x++;
    }

    while (true) {
        // this runs forever and is useful if you don't want the program to end unless manually terminated
    }
  }
}
```
#Classes and Methods
Methods:
```java
class Main {
  public static void main(String[] args) {
    sayHello();
    
    String farewell = sayGoodbye();
    System.out.println(farewell);

    System.out.println("3 is greater than 5: "+isGreaterThanFive(3));
    System.out.println("10 is greater than 5: "+isGreaterThanFive(10));

    imLate();
  }

  // public and static will be covered in a minute
  // void means the method doesn't return anything
  public static void sayHello() {
    System.out.println("Hello!");
  }

  // String means that the method returns a String
  public static String sayGoodbye() {
    return "Goodbye!";
  }

  // boolean so returns true/false
  public static boolean isGreaterThanFive(int n) {
    return (n>5);
  }

  //  prints the 'im late' song from alice in wonderland
  public static void imLate() {
    System.out.println("No time to say:");
    sayHello();
    System.out.println(sayGoodbye());
    System.out.println("I'm late!");  
  }   
}
```
Classes:
```java
class Main {
  public static void main(String[] args) {
    // create a new 'instance' of the dog class, called George
    Dog George = new Dog("George");
    George.bark();
    George.live();
    George.eat(); // fails because eat() is private
    Dog fred = new Poodle("Fred");
    fred.live();
    fred.setTrimmed(); // fails because fred is of type dog
    Poodle Joe = new Poodle("Joe", false);
    Joe.setTrimmed(); // works because joe is a poodle
    Joe.live();
  }
}

class Dog {
  // this is an attribute that all 
  // of our Dog objects will have
  String name;

  // this is called the constructor
  // it is called when the dog is created
  public Dog(String name) {
    // this. means that name applies the this dog
    // it means that it's name can be used elsewhere
    // in the class
    this.name = name;

    System.out.println("A dog called "+this.name+" was just created!");
  }

  // public means that it can be accessed by other classes
  public void bark() {
    System.out.println(this.name+" just said 'Woof!'");
  }

  public void live() {
    this.eat();
  }

  // private so cannot be accessed by other classes
  private void eat() {
    System.out.println(this.name+" is eating!");
  }
}

class Poodle extends Dog {
    public boolean trimmed;
    
    public Poodle(String name) {
        super(name);
        this.trimmed = false;
    }

    public Poodle(String name, boolean trimmed) {
        super(name);
        this.trimmed = trimmed;
    }

    public void setTrimmed() {
        this.trimmed = true;
        System.out.println(this.name + " loves their new haircut!");
    }   
}
```
Static Methods:
```java
class Main {
  public static void main(String[] args) {
    // create a new instance of the Shop class
    Shop Amazon = new Shop();
    Amazon.buy();

    // static, so we can just do this
    Shop.buy();

    Amazon.showDetails();

    // fails because it is not an instance
    // and the method is not static
    Shop.showDetails();
  }

    public void invalidMethod() {
        // this method cannot be called from a static context as it is a non static method and Main cannot be instantiated
    }
}

class Shop {
  // static so don't need to instantiate in order to 
  // use the method
  public static void buy() {
    System.out.println("Buying!");
  }

  public void showDetails() {
    System.out.println("You have to create a instance for this to work");
  }
}
```
#Input
Scanning Text: [see here for my spin on it](https://github.com/DaNrd/01_APCS/blob/master/projects/class/programmingContestOrientedProblem/2/actual/src/PcopTwo.java)
```java
import java.util.Scanner;
import java.io.File;

class Main {
  public static void main(String[] args) {
    // creates a new Scanner looking at the string "Hello World"
    Scanner input_reader = new Scanner("Hello World");

    // outputs each word one at a time
    while (input_reader.hasNext()) {
      String input = input_reader.next();
      System.out.println(input);
    }
  }
}
```
Scanning User Input: [see here for my spin on it](https://github.com/DaNrd/01_APCS/blob/master/projects/personal/physicsSim/src/Main.java)
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input_reader = new Scanner(System.in);

    System.out.println("Enter some text: ");
    String input = input_reader.nextLine();
    System.out.println("You said: "+input);
  }
}
```
#Error Handling
Try/Catch:
```java
import java.lang.ArithmeticException;

class Main {
  public static void main(String[] args) {
    try {
      System.out.println(1/0);
    } catch (ArithmeticException e) {
      System.out.println("Got error: "+e);
    }
    try {
        System.out.println(stackKiller(0));
    } catch (StackOverflowError e) {
        System.out.println("you got a stack overflow error");
    }
  }

    public static int stackKiller(int i) {
        i++;
        i = stackKiller(i);
        return i;
    }
}
```
