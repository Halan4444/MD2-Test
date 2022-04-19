package product.model;

public enum RoleName {
    ADMIN("ADMIN"), USER("USER");

    private String value;

    RoleName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static RoleName fromValue(String value){
        RoleName[] values = values();
        for (RoleName roleName :values) {
            if (roleName.value.equals(value))
                return roleName;
        }
        throw new IllegalArgumentException("invalid");
    }
}
