package com.company.Lab4;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Circle cr = new Circle(2);
        Rectangle rc = new Rectangle(1, 2, "Red", true);
        Square sq = new Square(3);
        System.out.println(cr.toString());
        System.out.println(sq.toString());
        System.out.println(rc.toString());

    }
}
