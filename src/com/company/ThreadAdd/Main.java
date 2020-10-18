package com.company.ThreadAdd;

import java.util.ArrayList;

public class Main {
    static int totalSum;
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Integer> counter = new ArrayList<Integer>();
        for (int i = 0; i <  4; i++){
            final int localI = i;
//            Thread thread = new Thread();
            counter.add(i);
            Thread thread = new Thread(() -> work(localI, counter));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        for (int j = 0; j < counter.size(); j++) {
            totalSum += counter.get(j);
        }
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i, ArrayList<Integer> counter) {
        long result;
        long startTime = System.currentTimeMillis();
        counter.set(i, 0);
        result = doHardWork(i * 1000, 100_000_000, counter, i);

        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count, ArrayList<Integer> counter, int index) {
        long a = 0;
        int i;
        for (i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
        }
        counter.set(index, i);
        return a;
    }
}

