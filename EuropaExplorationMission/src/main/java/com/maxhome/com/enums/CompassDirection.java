package src.main.java.com.maxhome.com.enums;

public enum CompassDirection {

    N("North"),
    S("South"),
    E("East"),
    W("West");

    CompassDirection(String name) {
        this.name = name;
    }

    public CompassDirection left() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public CompassDirection right() {
        switch (this) {
            case N: return E;
            case W: return N;
            case S: return W;
            case E: return S;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    private String name;

}
