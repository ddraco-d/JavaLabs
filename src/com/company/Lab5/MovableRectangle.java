package com.company.Lab5;

public class MovableRectangle extends Rectangle implements Movable{
    MovablePoint upperLeft;
    MovablePoint downRight;

    public MovableRectangle(double width, double length) {
        super(width, length);
        upperLeft = new MovablePoint(0,0);
        downRight = new MovablePoint(width, length);
    }

    @Override
    public void setLength(double length) {
        downRight.moveRight(length - this.length);
        super.setLength(length);
    }

    @Override
    public void setWidth(double width) {
        downRight.moveDown(width - this.width);
        super.setWidth(width);
    }

    @Override
    public void moveUp(double x) {
        upperLeft.moveUp(x);
        downRight.moveUp(x);
    }

    @Override
    public void moveDown(double x) {
        upperLeft.moveDown(x);
        downRight.moveDown(x);
    }

    @Override
    public void moveLeft(double y) {
        upperLeft.moveLeft(y);
        downRight.moveLeft(y);
    }

    @Override
    public void moveRight(double y) {
        upperLeft.moveRight(y);
        downRight.moveRight(y);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "upperLeft=" + upperLeft +
                ", downRight=" + downRight +
                '}';
    }
}
