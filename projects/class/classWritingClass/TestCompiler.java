import java.util.*;

public class TestCompiler {
    public static void main(String[] args) {
        Field token1 = new Field("int", "age");

        Field token2 = new Field("String", "favoriteColor", "red");

        ArrayList<Field> fieldList = new ArrayList<Field>();

        fieldList.add(token1);

        fieldList.add(token2);

        Classy  node1 = new Classy(fieldList);

        Object firstTokenValue = node1.getFieldValue("age");

        Object firstTokenName = node1.getFieldName(0);
        System.out.println(firstTokenName + " " + firstTokenValue);
    }
}