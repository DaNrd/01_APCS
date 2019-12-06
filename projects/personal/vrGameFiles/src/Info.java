import java.util.*;
import java.lang.String;

public class Info {
    public int gamemode;

    public void askMode() {
        System.out.println("Welcome to the description of the games. Please enter 1 for Atheism, 2 for Buddhism, or 3 for Christianity.");
        Scanner gamemodeScanner = new Scanner(System.in);
        gamemode = Integer.parseInt(gamemodeScanner.nextLine());
        helperMethod();
    }

    public void helperMethod() {
        if(gamemode == 1){
            coolTitleThing("Atheism");
            System.out.println("In the Atheism gamemode, you will be able to walk arround on a plane. If you fall off you die and there is no restart.");
        } else if(gamemode == 2) {
            coolTitleThing("Buddhism");
            System.out.println("In the Buddhism gamemode, you will be able to walk arround on a plane. If you fall off you die you come back as a duck.");
        } else if(gamemode == 3) {
            coolTitleThing("Christianity");
            System.out.println("In the Christianity gamemode, you will be able to walk arround on a plane. If you fall off you die and pick between heaven and hell.");
        } else {
            coolTitleThing("Error");
            System.out.println("Sorry, that gamemode doesn\'t exist yet.");
            askMode();
        }
    }

    public void coolTitleThing(String a){
        for(int i = 0; i < 3; i++) {
            System.out.print("-");
            if(i != 1) {
                for(int j = 0; j < a.length(); j++) {
                    System.out.print("-");
                }
            } else {
                System.out.print(a);
            }
            System.out.println("-");
        }
        System.out.println("");
    }
}