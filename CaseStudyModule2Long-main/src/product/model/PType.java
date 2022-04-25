package product.model;

public enum PType {
    FRANCE("FRANCE"), JAPAN("JAPAN"),GERMAN("GERMAN"), BRITAIN("BRITAIN"), AMERICA("AMERICA");
    ;
    private String value;

    PType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static boolean fromValue(String value) {
        PType[] values = values();
        for (PType type : values) {
            if (type.value.equals(value))
                return true;
        }

        return false;
    }

    public String contains(String type) {
        return type;
    }
}
