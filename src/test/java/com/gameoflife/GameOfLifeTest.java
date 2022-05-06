package com.gameoflife;

import com.gameoflife.Board.Board;
import com.gameoflife.Board.BoardController;
import com.gameoflife.Utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOfLifeTest {
    @Test
    void blockPattern() {
        Position[] aliveCellPositions = {
                new Position(1, 1),
                new Position(1, 2),
                new Position(2, 1),
                new Position(2, 2),
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(2, 1));
        expected.add(Arrays.asList(2, 2));

        int boardSize = 5;
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.runGame(boardSize, aliveCellPositions);
        List<List<Integer>> actual = gameOfLife.boardController.getAliveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void boatPattern() {
        Position[] aliveCellPositions = {
                new Position(0, 1),
                new Position(1, 0),
                new Position(2, 1),
                new Position(0, 2),
                new Position(1, 2),
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(0, 2));
        expected.add(Arrays.asList(1, 0));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(2, 1));

        int boardSize = 5;
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.runGame(boardSize, aliveCellPositions);
        List<List<Integer>> actual = gameOfLife.boardController.getAliveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void blinkerPattern() {
        Position[] aliveCellPositions = {
                new Position(1, 0),
                new Position(1, 1),
                new Position(1, 2),
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(2, 1));

        int boardSize = 5;
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.runGame(boardSize, aliveCellPositions);
        List<List<Integer>> actual = gameOfLife.boardController.getAliveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void toadPattern() {
        Position[] aliveCellPositions = {
                new Position(1, 1),
                new Position(1, 2),
                new Position(1, 3),
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 2));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 4));
        expected.add(Arrays.asList(2, 1));
        expected.add(Arrays.asList(2, 4));
        expected.add(Arrays.asList(3, 3));

        int boardSize = 5;
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.runGame(boardSize, aliveCellPositions);
        List<List<Integer>> actual = gameOfLife.boardController.getAliveCellsCoordinates();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
