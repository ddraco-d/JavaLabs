package com.company.Lab15_16;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a;
        ListNode S1 = new ListNode();
        ListNode S2 = new ListNode();
        ListNode S3 = new ListNode();
        ListNode S4 = new ListNode();
        ListNode S5 = new ListNode();
        ListNode head = S1;

        S1.set(0, "create_project", S2);
        S1.set(1, "add_library", S5);
        S2.set(0, "test", S3);
        S2.set(1, "drop_db", S4);
        S3.set(0, "drop_db", S4);
        S3.set(1, "add_library", S5);
        S4.set(0, "restart", S3);
        S4.set(1, "deploy", S5);
        S5.set(0, "deploy", S1);
        S5.set(1, "restart", S3);

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        while (a != -1) {
            for (int i = 0; i < 2; i++) {
                if (head.getStates()[i] == a) {
                    System.out.println(head.getCommand()[a]);
                    head = head.getPointers()[a];
                    break;
                }
            }
            a = sc.nextInt();
        }
    }
}
