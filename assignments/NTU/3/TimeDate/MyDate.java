public class MyDate {
    private int year;
    private int month;
    private int day;
    private String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

    public boolean isLeapYear(int year) {
        if(year%4==0 && year%100!=0 || year%400==0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidDate(int year, int month, int day) {
        if(1<=year && year<=9999 && 1<=month && month<=12 && 1<=day && day<=daysInMonths[month - 1]) {
            return true;
        } else if(1<=year && year<=9999 && month == 2 && day == 29 && isLeapYear(year)) {
            return true;
        } else {
            return false;
        }
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        int firstTwo = (int)(year / 100);
        int lastTwo = (int)(year - 100*firstTwo);
        int value = (Math.abs(firstTwo-17)%4*3);
        int d = (value + lastTwo + lastTwo/4 + month + day)%7;
        return strDays[d-1] + day + strMonths[month-1] + year;
    }

    public MyDate nextDay() {
        if(day++ > daysInMonths[month-1]) {
            if(month++ > 12) {
                return new MyDate(this.year++, 1, 1);
            } else {
                return new MyDate(this.year, this.month++, 1);
            }
        } else {
            return new MyDate(this.year, this.month++, this.day++);
        }
    }

    public nextMonth() {
        // todo
    }
}