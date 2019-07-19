package android.example.com.prayas;

public class Name {
    String code = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    String name=null;

    public Name(String code, String name, boolean selected) {
        this.code = code;
        this.name = name;
        this.selected = selected;
    }

    boolean selected=false;
}
