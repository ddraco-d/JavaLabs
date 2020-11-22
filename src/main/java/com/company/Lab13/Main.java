package com.company.Lab13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmthThatThrowException a = new SmthThatThrowException();
        Scanner sc = new Scanner(System.in);
        int b;
        System.out.println("Что прибавляем? Если число отрицательное - будет Exception");
        b = sc.nextInt();
        try {
            a.checkMyexception(b);
            a.addA(b);

        }
        catch (MineException ex1) {
            System.out.println("Сработал Mine Exception");
        }
        catch (Exception ex) {
            System.out.println("Сработал просто Exception");
        }
        finally {
            System.out.println(a.toString());
        }


        System.out.println("Что прибавляем для метода с RunTimeException?" +
                "Если число отрицательное - будет Exception, не пойманный try/catch");
        sc = new Scanner(System.in);
        a.checkMyRuntime(sc.nextInt());

        System.out.println(a.toString());
    }
}
