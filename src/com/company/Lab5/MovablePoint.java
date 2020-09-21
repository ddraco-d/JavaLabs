package com.company.Lab5;

public class MovablePoint implements Movable {
    private double x, y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void moveUp(double x) {
        this.x += x;
    }

    @Override
    public void moveDown(double x) {
        this.x -= x;
    }

    @Override
    public void moveLeft(double y) {
        this.y -= y;
    }

    @Override
    public void moveRight(double y) {
        this.y += y;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
