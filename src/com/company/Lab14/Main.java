package com.company.Lab14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int b;
        ArrayList<Rule> Rules = new ArrayList<>();
        Map<String, String> rules2 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String parse;
        String[] s;
        String to_out = "";
        String currentStr;

        b = sc.nextInt();
        for (int i = 0; i < b; i++) {
            sc = new Scanner(System.in);
            parse = sc.nextLine();
            s = parse.split(" ");
            Rules.add(new Rule(s[0], s[1]));
            rules2.put(s[0], s[1]);
        }


        sc = new Scanner(System.in);
        currentStr = sc.nextLine();
        for (int i = 0; i < currentStr.length(); i++) {
            int flag = 0;
            for (int j = 0; j < b; j++) {
                if (i + Rules.get(j).getA().length() < currentStr.length()) {
                    String key = currentStr.substring(i, i + Rules.get(j).getA().length());
                    if (Rules.get(j).getA().equals(key)) {
                        to_out += Rules.get(j).getB();
                        flag = 1;
                        i += Rules.get(j).getA().length() - 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                to_out += currentStr.charAt(i);
            }
        }

        System.out.println("Без регулярного выражения: " + to_out);

        to_out = "";
        int index;
        for (int i = 0; i < b; i++) {
            to_out += Rules.get(i).getA();
            if (i != b - 1) {
                to_out += "|";
            }
        }
        Matcher m = Pattern.compile(to_out).matcher(currentStr);
        System.out.println("Используя регулярное выражение: " + m.replaceAll(x -> rules2.get(x.group())));
    }
}