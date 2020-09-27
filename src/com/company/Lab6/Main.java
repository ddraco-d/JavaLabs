package com.company.Lab6;

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы");
        int n = in.nextInt();
        int sum = 0;
        int[][] matrix = new int[n][n];
        int[][] checker = new int[n][n];

//        System.out.println("Введите элементы матрицы");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Random rand = new Random();
                matrix[i][j] = rand.nextInt(100);
            }
        }
        checker[0][0] = matrix[0][0];
        System.out.println("Исходная матрица");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("%d\t",matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            checker[i][0] = matrix[i][0] + checker[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            checker[0][j] = matrix[0][j] + checker[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                checker[i][j] = Math.max(checker[i - 1][j], checker[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println("Checker");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("%d\t",checker[i][j]);
            }
            System.out.println();
        }
        System.out.println("Max " + checker[n - 1][n -1]);
        }
    }
