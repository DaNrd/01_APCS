import java.util.*;
import java.text.*;

public class Program {
    public static ArrayList<DAF> data = new ArrayList<>();
    public static List<String> states = Arrays.asList(new String[]{"alabama","alaska","arizona","arkansas","california","colorado","connecticut","delaware","florida","georgia","hawaii","idaho","illinois","indiana","iowa","kansas","kentucky","louisiana","maine","maryland","massachusetts","michigan","minnesota","mississippi","missouri","montana","nebraska","nevada","new hampshire","new jersey","new mexico","new york","north carolina","north dakota","ohio","oklahoma","oregon","pennsylvania","rhode island","south carolina","south dakota","tennessee","texas","utah","vermont","virginia","washington","west virginia","wisconsin","wyoming"});

    public static void main(String[] args) {
        Reader reader = new Reader();
        for(String s: reader.read()) {
            String[] values = s.split(",");
            data.add(new DAF(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])));
        }
        retrieve(selectState(), selectDate());
    }

    public static void retrieve(String state, String date) {
        if(!validState(state)) {
            System.out.println(" ");
            System.out.println("No data for " + state + ". Please check the spelling and re-enter:");
            System.out.println(" ");
            retrieve(selectState(), date);
        } else if (!validDate(date)) {
            System.out.println(" ");
            System.out.println("No data for " + state + " on " + date + ". Please double-check the date and re-enter:");
            System.out.println(" ");
            retrieve(state, selectDate());
        } else {
            for(DAF e: data) {
                if(e.getState().equals(state) && e.getDateString().equals(date)) {
                    System.out.println(" ");
                    System.out.println("{fips,numberOfCases,numberOfDeaths} = {" + e.getData() + "} in " + state + " on " + date + ".");
                    System.out.println(" ");
                    break;
                }
            }
            retrieve(selectState(), selectDate());
        }
    }

    public static String selectState() {
        System.out.println("Which state's data do you want to see:");
        Scanner stateScanner = new Scanner(System.in);
        return stateScanner.nextLine();
    }

    public static String selectDate() {
        System.out.println("Enter the desired date in the format yyyy-mm-dd:");
        Scanner dateScanner = new Scanner(System.in);
        return dateScanner.nextLine();
    }

    public static boolean validState(String state) {
        if(states.contains(state)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}