import java.util.*;

public class Classy {
    ArrayList<Field> fieldList;

    Classy() {
        this.fieldList = new ArrayList<>();
    }
    Classy(ArrayList<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Object getFieldValue(String name) {
        for(Field  e: fieldList) {
            if(e.getName().equals(name)) {
                return e.getValue();
            }
        }
        return null;
    }

    public String getFieldName(int index) {
        return fieldList.get(index).getName();
    }
}