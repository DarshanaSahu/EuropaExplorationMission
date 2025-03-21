package src.main.java.com.maxhome.com.entities;

import src.main.java.com.maxhome.com.enums.CompassDirection;
import src.main.java.com.maxhome.com.enums.Direction;
import src.main.java.com.maxhome.com.enums.ExplorerType;

public class Robot extends Explorer {

    private String name;
    private Position position;
    private CompassDirection compassDirection;

    public Robot(String name, int x, int y, CompassDirection compassDirection, int fuelQuantity) {
        super(name, ExplorerType.ROBOT, x, y, compassDirection, fuelQuantity);

    }

    // Change explorer direction based on instruction provided
    public Explorer changeDirection(Explorer robot, Direction direction) {
        if (direction.equals(Direction.L)) {
            robot.compassDirection = robot.compassDirection.left();
        } else if (direction.equals(Direction.R)) {
            robot.compassDirection = robot.compassDirection.right();
        }
        return this;
    }

    // Based on current explorer position get next position with the latest compass direction
    public Position nextPosition(Explorer robot, int adjust) {
        switch (robot.compassDirection) {
            case N -> {
                Position position = new Position(robot.position.getX(), robot.position.getY() + (1 * adjust));
                return position;
            } case E -> {
                Position position = new Position(robot.position.getX() + (1 * adjust), robot.position.getY());
                return position;
            } case S -> {
                Position position = new Position(robot.position.getX(), robot.position.getY() - (1 * adjust));
                return position;
            } case W -> {
                Position position = new Position(robot.position.getX() - (1 * adjust), robot.position.getY());
                return position;
            }
            default -> {
                return null;
            }
        }
    }

}
