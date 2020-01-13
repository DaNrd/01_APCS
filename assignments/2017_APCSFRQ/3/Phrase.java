public class Phrase {
    private String currentPhrase;
    public static void main(String[] args){
        Phrase phrase1 = new Phrase("A cat ate late.");
        phrase1.replaceNthOccurrence("at",1,"rane");
        System.out.println(phrase1);
        System.out.println(phrase1.findLastOccurrence("at"));
    }

    // constructs a new phrase object
    public Phrase(String p) {
        currentPhrase = p;
    }

    // returns index of nth occurence of str in current phase
    // returns -1 if nth occurence doesnt exist
    // precondition str.length() > 0; n > 0
//    postcondition current phrase isn't modified
    public int findNthOccurence(String str, int n) {
        return n;
    }

    // modifies current phrase by replacing nth occurence ofstr with repl
    // if nth occurence doesn't exist, phase is unchanged
    // precondition str.length() > 0 n > 0
    public void replaceNthOccurrence(String str, int n, String repl) {
        String[] splitPhrase = this.currentPhrase.split(str,-2);
        String retval = "";
        if(this.currentPhrase.substring(0,str.length() - 1) == str){
            retval += str;
        }
        for(int i = 0; i < n; i++) {
            retval += splitPhrase[i];
            retval += str;
        }
        retval = retval.substring(0,retval.length()-str.length());
        retval += repl;
        for(int i = n; i<splitPhrase.length; i++) {
            retval += splitPhrase[i];
            retval += str;
        }
        if(this.currentPhrase.substring(this.currentPhrase.length()-str.length(),this.currentPhrase.length()) != str) {
            retval = retval.substring(0,retval.length()-str.length());
        }
        this.currentPhrase = retval;
    }

    // returns index of last occurrence of str in current phase
    // returns -1 is str is not found
    // preconditiion str.length() > 0
    // postcondition current phase isn't modified
    public int findLastOccurrence(String str) {
        int pos = -1;
        for(int i = 0; i<this.currentPhrase.length()-str.length()+1; i++){
            if(this.currentPhrase.substring(i,i+str.length()).equals(str)) {
                pos = i;
            }
        }
        return pos;
    }

    // Returns a string containing the current phrase.
    public String toString() {
        return currentPhrase;
    }

}