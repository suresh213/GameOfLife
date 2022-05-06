package com.gameoflife.Utils;

public class Position {
    private final int xAxis;
    private final int yAxis;

    public Position(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getXAxis() {
        return this.xAxis;
    }

    public int getYAxis() {
        return this.yAxis;
    }
}
