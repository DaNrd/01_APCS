public class TestProgram {
    public static void main(String[] args) {
        Figure datarow0 = new Figure(1, "Kansas", 3, 20, 7);

        Figure datarow1 = new Figure(2, "Kansas", 3, 20, 8);

        Figure datarow2 = new Figure(3, "Kansas", 3, 22, 9);

        Figure datarow3 = new Figure(4, "Kansas", 3, 24, 10);

        Figure datarow4 = new Figure(5, "Kansas", 3, 26, 12);


// Create the objects required

        StateFigures KansasStats = new StateFigures();


// use the required method(s)

        KansasStats.insert(datarow0);

        KansasStats.insert(datarow1);

        KansasStats.insert(datarow2);

        KansasStats.insert(datarow3);

        KansasStats.insert(datarow4);


// inspect the results (should print 46)

        System.out.println(KansasStats.getTotalDeaths());
    }
}