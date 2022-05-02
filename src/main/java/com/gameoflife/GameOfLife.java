package com.gameoflife;

public class GameOfLife {
    Cell[][] board;

    public GameOfLife(Cell[][] board) {
        this.board = board;
    }

    public void nextGeneration() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                cell.evolve(board);
            }
        }
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.status == CellStatus.TOGGLEHELPER2) cell.setStatus(CellStatus.DEAD);
                if (cell.status == CellStatus.TOGGLEHELPER3) cell.setStatus(CellStatus.ALIVE);
            }
        }
    }
}