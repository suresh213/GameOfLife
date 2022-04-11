package com.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOfLifeTest {
    @Test
    void blockPattern() {
        int[][] coordinates = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        int[][] board = new int[5][5];

        for (int[] coordinate : coordinates) {
            board[coordinate[0]][coordinate[1]] = 1;
        }

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(2, 1));
        expected.add(Arrays.asList(2, 2));

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGeneration();
        List<List<Integer>> actual = gameOfLife.getLiveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void boatPattern() {
        int[][] coordinates = {{0, 1}, {1, 0}, {2, 1}, {0, 2}, {1, 2}};
        int[][] board = new int[5][5];

        for (int[] coordinate : coordinates) {
            board[coordinate[0]][coordinate[1]] = 1;
        }

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(0, 2));
        expected.add(Arrays.asList(1, 0));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(2, 1));

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGeneration();
        List<List<Integer>> actual = gameOfLife.getLiveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void blinkerPattern() {
        int[][] coordinates = {{1, 0}, {1, 1}, {1, 2}};
        int[][] board = new int[5][5];

        for (int[] coordinate : coordinates) {
            board[coordinate[0]][coordinate[1]] = 1;
        }

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(2, 1));

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGeneration();
        List<List<Integer>> actual = gameOfLife.getLiveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void toadPattern() {
        int[][] coordinates = {{1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {2, 4}};
        int[][] board = new int[5][5];

        for (int[] coordinate : coordinates) {
            board[coordinate[0]][coordinate[1]] = 1;
        }

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 2));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 4));
        expected.add(Arrays.asList(2, 1));
        expected.add(Arrays.asList(2, 4));
        expected.add(Arrays.asList(3, 3));

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGeneration();
        List<List<Integer>> actual = gameOfLife.getLiveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
