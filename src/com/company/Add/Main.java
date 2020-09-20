package com.company.Add;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a = 1;
        int a1 = 3;
        int a2 = 5;
        int i = 0, j = 0, k = 0;
        int counter = 0;

        while (i <= N) {
            j = 0;
            while (j <= N / 3) {
                k = 0;
                while (k <= N / 5) {
                    counter = (i * a + j * a1 + k * a2 == N) ? counter + 1 : counter;
                    k++;
                }
                j++;
            }
            i++;
        }
        System.out.println("N = " + N + ": " + counter);
    }
}
