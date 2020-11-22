package com.company.Lab12;

public class Main {

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        color("1", Enums.BLACK);
        color("2", Enums.RED);
        color("3", Enums.GREEN);
        color("4", Enums.YELLOW);
        color("5", Enums.BLUE);
        color("6", Enums.MAGENTA);
        color("7", Enums.CYAN);
        color("8", Enums.WHITE);
    }

    public static void color(String s, Enums a) {
        System.out.println(a.getField() + s + RESET);
    }
}
