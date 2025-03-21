package src.main.java.com.maxhome.com.entities;

import src.main.java.com.maxhome.com.enums.CompassDirection;
import src.main.java.com.maxhome.com.enums.Direction;
import src.main.java.com.maxhome.com.enums.ExplorerType;

public abstract class Explorer {

    protected String name;
    protected ExplorerType type;
    protected Position position;
    protected CompassDirection compassDirection;
    protected int fuelQuantity;

    public Explorer(String name, ExplorerType type, int x, int y, CompassDirection compassDirection, int fuelQuantity) {
        this.name = name;
        this.type = type;
        this.position = new Position(x, y);
        this.compassDirection = compassDirection;
        this.fuelQuantity = fuelQuantity;
    }

    public ExplorerType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public CompassDirection getCompassDirection() {
        return compassDirection;
    }

    public abstract Explorer changeDirection(Explorer explorer, Direction direction);
    public abstract Position nextPosition(Explorer explorer, int adjustment);
}
