package hbv.Enum;

public enum Path {
    NOT_FOUND("/404.html"),
    LOGIN("/login"),
    LOGOUT("/login"),
    REGESTRATION("/register"),
    KURS("/kurs"),
    USER("/user"),
    STUDIENGANG("/studiengang");

    private final String name;

    Path(String name) {
        this.name = "/docker-swe3-21-team-a-java" + name;
    }

    public String getPath() {
        return name;
    }
}
