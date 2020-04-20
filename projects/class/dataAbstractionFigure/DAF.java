public class DAF {
    public int date;
    public String dateString;
    public int fips;
    public int numVirusCases;
    public int numVirusDeaths;
    public String state;
    private int day0;

    DAF(String dateString, String state, int fips, int numVirusCases, int numVirusDeaths) {
        this.day0 = convertDateToDays("2020-01-01");
        this.date = convertDateToDays(dateString) - day0;
        this.dateString = dateString;
        this.state = state;
        this.fips = fips;
        this.numVirusCases = numVirusCases;
        this.numVirusDeaths = numVirusDeaths;
    }

    DAF(String dateString, String state, int fips, int numVirusCases, int numVirusDeaths, String day0) {
        this.day0 = convertDateToDays(day0);
        this.date = convertDateToDays(dateString);
        this.dateString = dateString;
        this.state = state;
        this.fips = fips;
        this.numVirusCases = numVirusCases;
        this.numVirusDeaths = numVirusDeaths;
    }

    public int getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public int getFips() {
        return fips;
    }

    public int getNumVirusCases() {
        return numVirusCases;
    }

    public int getNumVirusDeaths() {
        return numVirusDeaths;
    }

    public int getDay0() {
        return day0;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public void setNumVirusCases(int numVirusCases) {
        this.numVirusCases = numVirusCases;
    }

    public void setNumVirusDeaths(int numVirusDeaths) {
        this.numVirusDeaths = numVirusDeaths;
    }

    public void setDay0(int day0) {
        this.day0 = day0;
    }

    public String toString() {
        return "It has been " + date + " days since day 0. There were " + numVirusCases + " total cases and " + numVirusDeaths + " total deaths on " + dateString + ". The fips value on this day was " + fips + ".";
    }

    public int convertDateToDays(String dateString) {
        int year = Integer.parseInt(dateString.substring(0,4));
        int month = Integer.parseInt(dateString.substring(5,7));
        int day = Integer.parseInt(dateString.substring(8,10));
        int[] daysInMonth = new int[]{0,31,59,90,120,151,181,212,243,273,304,334}; // number of days that must pass for it to become the month that the index+1 represents
        int date = (365*year) + daysInMonth[month-1] + day;
        if(year%4 == 0 && month>2) { // deals with leap-years
            date += year/4;
        }
        return date;
    }
}