package com.gameoflife.Board;

import com.gameoflife.Cell.Cell;
import com.gameoflife.Cell.CellStatus;
import com.gameoflife.Utils.Directions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardController {
    Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void update() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                int aliveNeighboursCount = getAliveNeighboursCount(board.currentState[i][j]);
                boolean isLiving = board.currentState[i][j].isAlive();
                boolean nextStateOfCell = isLiving;

                if (isLiving) {
                    if (aliveNeighboursCount < 2) nextStateOfCell = false;
                    else if (aliveNeighboursCount > 3) nextStateOfCell = false;
                } else {
                    if (aliveNeighboursCount == 3) nextStateOfCell = true;
                }
                board.nextState[i][j] = nextStateOfCell;
            }
        }
        setNextState();
    }

    private void setNextState() {
        for (int row = 0; row < board.size; row++) {
            for (int col = 0; col < board.size; col++) {
                board.currentState[row][col].setStatus(board.nextState[row][col] ? CellStatus.ALIVE : CellStatus.DEAD);
            }
        }
    }

    private int getAliveNeighboursCount(Cell cell) {
        int neighboursCount = 0;

        for (Directions direction : Directions.values()) {
            int x = direction.getMovement().getXAxis() + cell.getPosition().getXAxis();
            int y = direction.getMovement().getYAxis() + cell.getPosition().getYAxis();

            if (x >= 0 && x < board.size && y >= 0 && y < board.size) {
                if (board.currentState[x][y].isAlive()) {
                    ++neighboursCount;
                }
            }
        }
        return neighboursCount;
    }

    public List<List<Integer>> getAliveCellsCoordinates() {
        List<List<Integer>> liveCellsCoordinates = new ArrayList<>();

        for (int row = 0; row < board.size; row++) {
            for (int col = 0; col < board.size; col++) {
                if (board.currentState[row][col].getStatus() == CellStatus.ALIVE) {
                    liveCellsCoordinates.add(Arrays.asList(row, col));
                }
            }
        }
        return liveCellsCoordinates;
    }
}
