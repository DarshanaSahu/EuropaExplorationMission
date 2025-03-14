package com.maxhome.com.entities;

import com.maxhome.com.enums.CompassDirection;
import com.maxhome.com.enums.Direction;
import com.maxhome.com.enums.ExplorerType;

public abstract class Explorer {

    protected String name;
    protected ExplorerType type;
    protected Position position;
    protected CompassDirection compassDirection;

    public Explorer(String name, ExplorerType type, int x, int y, CompassDirection compassDirection) {
        this.name = name;
        this.type = type;
        this.position = new Position(x, y);
        this.compassDirection = compassDirection;
    }

    public ExplorerType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public abstract Explorer changeDirection(Explorer explorer, Direction direction);
    public abstract Position nextPosition(Explorer explorer);
}
