package src.main.java.com.maxhome.com.enums;

public enum Direction {

    L("Left"),
    R("Right"),
    M("Forward"),
    B("Back");

    Direction(String movement) {
        this.movement = movement;
    }

    private String movement;

    public String getMovement() {
        return movement;
    }
}
