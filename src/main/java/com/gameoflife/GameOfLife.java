package com.gameoflife;

import com.gameoflife.Board.Board;
import com.gameoflife.Board.BoardController;
import com.gameoflife.Utils.Position;

public class GameOfLife {
    Board board;
    BoardController boardController;

    public void runGame(int boardSize, Position[] aliveCellPositions) {
        this.board = new Board(boardSize, aliveCellPositions);
        this.boardController = new BoardController(board);

        boardController.update();
    }
}