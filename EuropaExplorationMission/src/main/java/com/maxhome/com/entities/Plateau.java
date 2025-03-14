package com.maxhome.com.entities;

import com.maxhome.com.enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Plateau {

    private int length;
    private int breadth;
    private Map<String, Explorer> positionHolder;

    public Plateau(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        this.positionHolder = new HashMap<>();
    }

    // Check if position is available or occupied by other explorer
    public boolean isPositionAvailable(Position position) {
        return !positionHolder.containsKey(position.getX() + "-" + position.getY());
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
            if (Direction.valueOf(String.valueOf(ch)).equals(Direction.M)) {

                Position newPosition = explorer.nextPosition(explorer); // get the new position based on current explorer position

                if (isValidPosition(newPosition) && isPositionAvailable(newPosition)) {
                    updatePosition(explorer, explorer.position, newPosition);
                    explorer.position = newPosition;
                } else {
                    throw new RuntimeException("Either not valid position or position already occupied");
                }
            } else {
                explorer.changeDirection(explorer, Direction.valueOf(String.valueOf(ch)));
            }
        }
        return explorer.position;
    }

    // Add explorer in position holder map with the position
    public void addExplorer(Explorer explorer) {
        if (isValidPosition(explorer.position) && isPositionAvailable(explorer.position)) {
            positionHolder.put(explorer.position.getX() + "-" + explorer.position.getY(), explorer);
        } else {
            throw new RuntimeException("Either not valid position or position already occupied");
        }
    }
}
