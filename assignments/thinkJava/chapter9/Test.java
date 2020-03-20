public class Test {
    public static void main(String[] args) {
        /*
                bool    char        int         double      string
        bool    {0}     {0}         {0}         {0}         {str}
        char    {0}     {int}       {int}       {double}    {str}
        int     {0}     {int}       {int}       {double}    {str}
        double  {0}     {double}    {double}    {double}    {str}
        string  {str}   {str}       {str}       {str}       {str}
        */

        // vars used to test
        boolean a = true;
        char b = 'b';
        int c = 5;
        double d = 7.0;
        String e = "helloThere";
    }
}

/*

4:
    the ++ just incraments the char up one but the +1 tries to combine two uncompatable types

5:
    treated as any other string

6:
    int to double, char or int or double or boolean to string, boolean to int or double, certain ints or doubles to boolean, certain ints to char
*/