package com.company.Lab4;

public class Square extends Shape {
    private double side;

    Square() {}
    Square(double side) {
        super("Black", false);
        this.side = side;
    }

    Square(double side, String color, boolean filled)
    {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side + this.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

