package hbv.Enum;

public enum Studiengang {
    INF("Informatik", 1),
    WINF("Wirtschaftsinformatik", 2),
    DMP("Digitale Medienproduktion", 3);

    
    private final String name;
    private final int id;

    Studiengang(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static int getID(String value) {
        for (Studiengang s : values()) {
            if (s.name.equalsIgnoreCase(value)) {
                return s.id;
            }
        }
        return 1;
    }
}
