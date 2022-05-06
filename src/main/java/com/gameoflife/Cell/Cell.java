package com.gameoflife.Cell;

import com.gameoflife.Utils.Position;

public class Cell {
    private final Position position;
    private CellStatus status;

    public Cell(Position position, CellStatus status) {
        this.position = position;
        this.status = status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public CellStatus getStatus() {
        return this.status;
    }

    public boolean isAlive() {
        return status == CellStatus.ALIVE;
    }

    public Position getPosition() {
        return this.position;
    }
}
