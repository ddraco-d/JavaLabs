package com.company.Lab11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static int total = 0;
    static AtomicInteger totalSum = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        //1
        for (int i = 0; i < 10; i++) {
            doHardWork(i * 1000, 100_000_000);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));

        System.out.println("Результат для одного потока: " + total);
        total = 0;
        //2

        startTime = System.currentTimeMillis();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> doHardWork(localI * 1000, 100_000_000));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
        System.out.println("Результат для многопоточной обработки, без синхронизирования : " + total);
        //3
        total = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> doHardWorkSync(localI * 1000, 100_000_000));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
        System.out.println("Результат для многопоточной обработки, с синхронизированием : " + totalSum);
    }
    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i) * Math.sqrt(start + i);
            total++;
        }
        return a;
    }

    private static long doHardWorkSync(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i) * Math.sqrt(start + i);
            totalSum.incrementAndGet();
        }
        return a;
    }
}
