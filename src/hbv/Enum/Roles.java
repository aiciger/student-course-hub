package hbv.Enum;

public enum Roles {
    PROFESSOR("professor"),
    STUDENT("student"),
    ADMIN("admin");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public static String findByValue(String value) {
        String result = null;
        for (Roles role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                result = role.value;
                break;
            }
        }
        return result;
    }
}
