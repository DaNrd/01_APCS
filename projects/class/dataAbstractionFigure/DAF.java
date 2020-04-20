public class DAF {
    public int date;
    public int fips;
    public int numVirusCases;
    public int numVirusDeaths;

    DAF(int date; int fips; int numVirusCases; int numVirusDeaths) {
        this.date = date;
        this.fips = fips;
        this.numVirusCases = numVirusDeaths;
        this.numVirusDeaths = numVirusDeaths;
    }

    public int getDate() {
        return date;
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

    public void setDate(int date) {
        this.date = date;
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

    public String toString() {
        return "For this particular DAF, there were " + numVirusCases + " cases and " + numVirusDeaths + " deaths on " + date + " bringing the death rate of the virus to " + (numVirusDeaths / (double) numVirusCases) + ". The fips value on this day was " + fips + ".";
    }
}