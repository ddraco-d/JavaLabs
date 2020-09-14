package com.company.Lab1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int fact(int a)
    {
        int result = 1;
        for (int i = 1; i <= a; i ++){
            result = result*i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] b = new int[10];
        int sum = 0;
        int x = 0;
        for (int i = 0; i < 10; i++) {
            b[i] = i;
        }

        //1
        for (int i = 0; i < 10; i++)
            sum += b[i];
        System.out.println(sum);
        sum = 0;
        //2
        while (x < b.length)
            sum += b[x++];
        System.out.println(sum);
        //3
        x = 0;
        sum = 0;
        do {
            sum += b[x++];
        } while (x < b.length);
        System.out.println(sum);

        //2.1
        for (int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
        }

        //3

        for (int i = 1; i < 11; i++) {
            System.out.println(1./i);
        }
        System.out.println("\n4.1)");
        //4.1
        int [] arr = new int [10];
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(100);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        System.out.println('\n');
        Arrays.sort(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

        //4.2
        System.out.println("\n4.2)");
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(10 + Math.random() * 90);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        System.out.println('\n');
        Arrays.sort(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        //5
        System.out.println("\n5)");
        System.out.println(fact(5));


    }

}
