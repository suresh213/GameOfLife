package com.gameoflife.Board;

import com.gameoflife.Cell.Cell;
import com.gameoflife.Cell.CellStatus;
import com.gameoflife.Utils.Position;

public class Board {
    final int size;
    Cell[][] currentState;
    Boolean[][] nextState;
    private final BoardController boardController;

    public Board(int size, Position[] aliveCellPositions) {
        this.size = size;
        currentState = new Cell[size][size];
        nextState = new Boolean[size][size];
        boardController = new BoardController(this);

        initializeState(size, aliveCellPositions);
    }

    private void initializeState(int size, Position[] aliveCellPositions) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Position position = new Position(row, col);
                currentState[row][col] = new Cell(position, CellStatus.DEAD);
                nextState[row][col] = false;
            }
        }

        for (Position position : aliveCellPositions) {
            currentState[position.getXAxis()][position.getYAxis()] = new Cell(position, CellStatus.ALIVE);
            nextState[position.getXAxis()][position.getYAxis()] = true;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.println(currentState[row][col].isAlive());
            }
            System.out.println();
        }
    }

    public BoardController getBoardController() {
        return boardController;
    }
}