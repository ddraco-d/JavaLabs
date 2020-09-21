package com.company.Lab5;

public class MovableCircle extends Circle implements Movable {

    private int x, y;
    public MovableCircle(double radius) {
        super(radius);
        x = 0;
        y =0;
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
        return "MovableCircle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
