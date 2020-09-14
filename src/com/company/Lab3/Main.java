package com.company.Lab3;

public class Main {

    public static void main(String[] args) {
        Human.Hand a1 = new Human.Hand("Black");
        Human.Hand a2 = new Human.Hand("Black");
        Human.Leg b1 = new Human.Leg(20);
        Human.Leg b2 = new Human.Leg(21);
        Human.Head c = new Human.Head("Style", "Round");

        Human j = new Human(190, "alex", c, b1, b2, a1, a2);
        System.out.println(j.toString());
    }
}
