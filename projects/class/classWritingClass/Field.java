import java.util.*;

public class Field {
    public String type;
    public String name;
    public Object value;

    Field(String type, String name) {
        this.type = type;
        this.name = name;
        value = null;
    }

    Field(String type, String name, String value) {
        this.type = type;
        this.name = name;
        computeValue(value);
    }

    public void computeValue(String value) {
        switch(this.type) {
            case "int":
                this.value = new Integer(Integer.parseInt(value));
                break;
            case "double":
                this.value = new Double(Double.parseDouble(value));
                break;
            case "String":
                this.value = new String(value);
                break;
            case "Char":
                this.value = new Character(value.charAt(0));
                break;
            case "boolean":
                if(value.equals("true")) {
                    this.value = new Boolean(true);
                } else {
                    this.value = new Boolean(false);
                }
                break;
        }
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return value;
    }

    public String toString() {
        return "Field(type=" + type + ", name=" + name + ", value=" + value + ")";
    }
}