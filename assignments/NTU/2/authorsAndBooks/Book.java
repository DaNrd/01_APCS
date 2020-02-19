public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        String strings = "";
        String retval = "";
        for(Author e: this.authors) {
            strings += e.toString();
            strings += ",";
        }
        for(int i = 0; i < strings.length() - 1; i++) {
            retval += strings.charAt(i);
        }
        return "Book[name="+this.name+","+retval+",price="+this.price+",qty="+this.qty+"]";
    }

    public String getAuthorNames() {
        String names = "";
        String retval = "";
        for(Author e: this.authors) {
            names += e.getName();
            names += ",";
        }
        for(int i = 0; i < names.length() - 1; i++) {
            retval += names.charAt(i);
        }
        return retval;
    }

    public String getAuthorEmails() {
        String emails = "";
        String retval = "";
        for(Author e: this.authors) {
            emails += e.getEmail();
            emails += ",";
        }
        for(int i = 0; i < emails.length() - 1; i++) {
            retval += emails.charAt(i);
        }
        return retval;
    }

    public String getAuthorGenders() {
        String genders = "";
        String retval = "";
        for(Author e: this.authors) {
            genders += e.getEmail();
            genders += ",";
        }
        for(int i = 0; i < genders.length() - 1; i++) {
            retval += genders.charAt(i);
        }
        return retval;
    }
}