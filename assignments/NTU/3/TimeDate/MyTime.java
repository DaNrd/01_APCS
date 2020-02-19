public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toString() {
        String retval;
        if(this.hour < 10) {
            retval += "0"+this.hour;
        } else {
            retval += this.hour;
        }
        retval +=":";
        if(this.minute < 10) {
            retval += "0"+this.minute;
        } else {
            retval += this.minute;
        }
        retval +=":";
        if(this.second < 10) {
            retval += "0"+this.second;
        } else {
            retval += this.second;
        }
        return retval;
    }

    public MyTime nextHour() {
        this.hour++;
        return this;
    }

    public MyTime nextMinute() {
        this.minute++;
        return this;
    }

    public MyTime nextSecond() {
        this.second++;
        return this;
    }

    public MyTime previousHour() {
        this.hour--;
        return this;
    }

    public MyTime previousMinute() {
        this.minute--;
        return this;
    }

    public MyTime previousSecond() {
        this.second--;
        return this;
    }
}