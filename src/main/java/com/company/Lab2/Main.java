package com.company.Lab2;

public class Main {

    public static void main(String[] args) {
        Shape a = new Shape();
        a.length = 5;
        a.width = 10;
        a.toString();


        //last
        Dog b = new Dog();
        b.setAge(10);
        b.setName("Vanya");
        System.out.println(b.to_human());
        System.out.println(b.toString());
        dog_nursery c = new dog_nursery();
        c.add(b);

    }
}
