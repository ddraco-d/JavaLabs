package com.company.Lab5;

public class Main {
    public static void main(String[] args) {
        MovableCircle Circle = new MovableCircle(5);
        System.out.println(Circle);
        Circle.moveDown(20);
        Circle.moveLeft(10);
        System.out.println(Circle);

        //2
        MovableRectangle Rect = new MovableRectangle(10, 20);
        System.out.println(Rect);
        Rect.moveLeft(10);
        System.out.println(Rect);
        Rect.moveDown(20);
        System.out.println(Rect);
        Rect.setWidth(30);
        System.out.println(Rect);
    }
}
