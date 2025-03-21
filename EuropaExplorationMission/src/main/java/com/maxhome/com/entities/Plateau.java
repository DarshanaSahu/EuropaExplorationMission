package src.main.java.com.maxhome.com.entities;

import src.main.java.com.maxhome.com.enums.CompassDirection;
import src.main.java.com.maxhome.com.enums.Direction;

import java.util.*;

public class Plateau {

    private int id;
    private int length;
    private int breadth;
    private Robot robot;
    private Map<String, Explorer> positionHolder;

    public Plateau(int id, int length, int breadth) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.positionHolder = new HashMap<>();
    }

    public Robot getRobot() {
        return this.robot;
    }

    public Position getPosition() {
        return this.robot.getPosition();
    }

    public CompassDirection getCompassDirection() {
        return this.robot.getCompassDirection();
    }

    // Check if position is available or occupied by other explorer
    public boolean isPositionAvailable(Position position) {
        return !positionHolder.containsKey(position.getX() + "-" + position.getY()) ;
    }

    // Check if position is valid with in the plateau
    public boolean isValidPosition(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > length || position.getY() > breadth) {
            return false;
        } else {
            return true;
        }
    }

    // Update the explorer position in the position holder map
    public void updatePosition(Explorer explorer, Position currPosition, Position newPosition) {
        if (positionHolder.containsKey(currPosition.getX() + "-" + currPosition.getY())) {
            positionHolder.remove(currPosition.getX() + "-" + currPosition.getY());
            positionHolder.put(newPosition.getX() + "-" + newPosition.getY(), explorer);
        }
    }

    // Follow instructions provided as an input
    public Position followInstruction(Explorer explorer, String instructions) {

        for (char ch : instructions.toCharArray()) { // loop over each instruction
            if (explorer.fuelQuantity > 0) {
                if (Direction.valueOf(String.valueOf(ch)).equals(Direction.M) || Direction.valueOf(String.valueOf(ch)).equals(Direction.B)) {
                    int adjustment = Direction.valueOf(String.valueOf(ch)).equals(Direction.M) ? 1 : -1;
                    Position newPosition = explorer.nextPosition(explorer, adjustment); // get the new position based on current explorer position

                    if (isValidPosition(newPosition) && isPositionAvailable(newPosition)) {
                        updatePosition(explorer, explorer.position, newPosition);
                        explorer.fuelQuantity--;
                        explorer.position = newPosition;
                    } else {
                        throw new RuntimeException("Either not valid position or position already occupied");
                    }
                } else {
                    explorer.changeDirection(explorer, Direction.valueOf(String.valueOf(ch)));
                    explorer.fuelQuantity--;
                }
            } else {
                throw new RuntimeException(String.format("Out of fuel - last position %s", explorer.position.getX() + " " + explorer.position.getY()));
            }
        }
        return explorer.position;
    }

    // Add explorer in position holder map with the position
    public void addExplorer(Explorer explorer) {
        if (isValidPosition(explorer.position) && isPositionAvailable(explorer.position)) {
            this.robot = (Robot) explorer;
            positionHolder.put(explorer.position.getX() + "-" + explorer.position.getY(), explorer);
        } else {
            throw new RuntimeException("Either not valid position or position already occupied");
        }
    }

}
