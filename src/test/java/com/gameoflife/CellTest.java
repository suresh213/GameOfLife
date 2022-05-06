package com.gameoflife;

import com.gameoflife.Cell.Cell;
import com.gameoflife.Cell.CellStatus;
import com.gameoflife.Utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void shouldReturnTrueWhenCellIsAlive() {
        Position position = new Position(1, 2);
        assertTrue(new Cell(position, CellStatus.ALIVE).isAlive());
    }

    @Test
    void shouldReturnFalseWhenCellIsNotAlive() {
        Position position = new Position(1, 2);
        assertFalse(new Cell(position, CellStatus.DEAD).isAlive());
    }

    @Test
    void shouldSetStatusOfCellAsAlive(){
        Position position = new Position(1, 2);
        Cell cell = new Cell(position, CellStatus.DEAD);
        cell.setStatus(CellStatus.ALIVE);

        assertTrue(cell.isAlive());
    }
}