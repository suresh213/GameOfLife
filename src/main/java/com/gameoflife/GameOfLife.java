package com.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {
    private final int[][] board;

    public GameOfLife(int[][] board) {
        this.board = board;
    }

    public void nextGeneration() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = getNeighboursCount(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 2;
                } else {
                    if (count == 3) board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }

    private static int getNeighboursCount(int[][] board, int i, int j) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int neighboursCount = 0;
        for (int k = 0; k < 8; k++) {
            int x = directions[k][0] + i;
            int y = directions[k][1] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[x][y] == 1 || board[x][y] == 2) ++neighboursCount;
            }
        }
        return neighboursCount;
    }

    public List<List<Integer>> getLiveCellsCoordinates() {
        List<List<Integer>> liveCellsCoordinates = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    liveCellsCoordinates.add(Arrays.asList(i, j));
                }
            }
        }
        return liveCellsCoordinates;
    }
}
