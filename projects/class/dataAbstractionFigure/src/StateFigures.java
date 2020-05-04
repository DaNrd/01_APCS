import java.util.*;
public class StateFigures {
    ArrayList<Figure> FigureList;


    public StateFigures() {
        this.FigureList = new ArrayList<>();
    }

    public void insert(Figure item) {
        this.FigureList.add(item);
    }

    public ArrayList<Figure> getFigures() {
        return this.FigureList;
    }

    public String getState() {
        return FigureList.get(0).getState();
    }

    public int getTotalFips() {
        int retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getFips();
        }
        return retval;
    }

    public int getTotalCases() {
        int retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getNumVirusCases();
        }
        return retval;
    }

    public int getTotalDeaths() {
        int retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getNumVirusDeaths();
        }
        return retval;
    }

    public double getAverageFips() {
        double retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getFips();
        }
        return retval/this.FigureList.size();
    }

    public double getAverageCases() {
        double retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getNumVirusCases();
        }
        return retval/this.FigureList.size();
    }

    public double getAverageDeaths() {
        double retval = 0;
        for(Figure e: this.FigureList) {
            retval += e.getNumVirusDeaths();
        }
        return retval/this.FigureList.size();
    }
}