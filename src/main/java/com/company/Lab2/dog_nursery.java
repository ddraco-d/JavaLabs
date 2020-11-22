package com.company.Lab2;

public class dog_nursery {
    int place = 0;
    Dog []arr = new Dog[10];

    public void add(Dog dog)
    {
        arr[place] = dog;
        place++;
        System.out.println("succes");
    }
}
