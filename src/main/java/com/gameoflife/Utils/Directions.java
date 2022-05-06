package com.gameoflife.Utils;

public enum Directions {
    UP(new Position(-1, 0)),
    LEFT(new Position(0, -1)),
    RIGHT(new Position(0, 1)),
    DOWN(new Position(1, 0)),
    TOP_LEFT(new Position(-1, -1)),
    TOP_RIGHT(new Position(-1, 1)),
    BOTTOM_LEFT(new Position(1, -1)),
    BOTTOM_RIGHT(new Position(1, 1));

    final Position movement;

    Directions(Position movement) {
        this.movement = movement;
    }

    public Position getMovement(){
        return this.movement;
    }
}
