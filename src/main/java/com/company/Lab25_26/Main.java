package com.company.Lab25_26;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MHashMap<Integer, String> myHashMap = new MHashMap();
        HashMap<Integer, String> HashMap1 = new HashMap();
        myHashMap.add(1, "Hello");
        myHashMap.add(129, "World");
        myHashMap.add(5, "!");

        HashMap1.put(1, "Hello");
        HashMap1.put(129, "World");
        HashMap1.put(5, "!");


        System.out.println("\nmy hashmap\n");
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(5));
        System.out.println(myHashMap.get(129));
        System.out.println("Deleted: " + myHashMap.remove(1));

        System.out.println("Cycle for my hashmap: ");
        for (String map : myHashMap) {
            System.out.println(map);
        }

        System.out.println("\nreal hashmap\n");
        System.out.println(HashMap1.get(1));
        System.out.println(HashMap1.get(5));
        System.out.println(HashMap1.get(129));
        System.out.println("Deleted: " + HashMap1.remove(1));

        System.out.println("Cycle for real hashmap: ");
        for (String map : HashMap1.values()) {
            System.out.println(map);
        }
    }
}
