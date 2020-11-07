##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab1/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab6/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/EmpHandler.java
```java
package com.company.Lab9;

public interface EmpHandler {
    void handleEmp(Employeee emp, int index);
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/EmploySelector.java
```java
package com.company.Lab9;

public interface EmploySelector {
    boolean isNeedEmployee(Employeee emp);
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/Main.java
```java
package com.company.Lab9;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company cmp = new Company();
        Random r = new Random(123);
        LocalDate ld = LocalDate.of(1999, 4, 25);
        for (int i = 0; i < 10; i++) {
            cmp.hire(new Employeee(ld, "Ivan", "Ivanov", "Moscow",
                    "77777", 20_000 + r.nextInt(5000)));
            ld = ld.plusDays(5);
        }

        cmp.handle_employees(new SalarySelector(21_000, 23_000),
                (Employeee, i) -> System.out.println("employee" + i + ":" + Employeee) );


        int basesalary = 21000;
        cmp.handle_employees(new EmploySelector() {
            @Override
            public boolean isNeedEmployee(Employeee emp) {
                return emp.getSalary() > basesalary;
            }
        }, new EmpHandler() {
            @Override
            public void handleEmp(Employeee emp, int index) {
                System.out.println("-" + index + "-");
                System.out.println(emp);
            }
        });

        System.out.println();

        cmp.handle_employees(Employeee -> Employeee.getSalary() > 24_000,
                (Employeee, i) -> System.out.println("*****" + i + "****\n" + Employeee));
    }


}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/Employeee.java
```java
package com.company.Lab9;

import java.time.LocalDate;

public class Employeee {
    private LocalDate ld;
    private String name, surname;
    private String placeOfLiving;
    private String phoneNumber;
    private int salary;

    public Employeee(LocalDate ld, String name, String surname, String placeOfLiving, String phoneNumber, int salary) {
        this.ld = ld;
        this.name = name;
        this.surname = surname;
        this.placeOfLiving = placeOfLiving;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public LocalDate getLd() {
        return ld;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "ld=" + ld +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", placeOfLiving='" + placeOfLiving + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/Company.java
```java
package com.company.Lab9;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employeee> staff = new ArrayList<>();
    public void hire(Employeee st)
    {
        staff.add(st);
    }
    public void hireAll(List <Employeee> st)
    {
        staff.addAll(st);
    }
    void fire(Employeee person)
    {
        staff.remove(person);
    }

    void handle_employees(EmploySelector selector, EmpHandler handler) {
        int count = 0;
        for (Employeee employeee : staff) {
            if (selector.isNeedEmployee(employeee)) {
                handler.handleEmp(employeee, count);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "staff=" + staff +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab9/SalarySelector.java
```java
package com.company.Lab9;

public class SalarySelector implements EmploySelector {

    private int Salarystart;
    private int SalaryyEnd;

    public SalarySelector(int Salarystart, int salaryyEnd) {
        this.Salarystart = Salarystart;
        this.SalaryyEnd = salaryyEnd;
    }

    @Override
    public boolean isNeedEmployee(Employeee emp) {
        return emp.getSalary() >= Salarystart && emp.getSalary() <= SalaryyEnd;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/Manager.java
```java
package com.company.Lab7_8;

public class Manager implements EmployeePosition{

    private int x;
    public Manager() {
        x = 115000 + (int)(Math.random()*(25001));
    }

    public int GetIn()
    {
        return (x);
    }


    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return x + baseSalary;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/Operator.java
```java
package com.company.Lab7_8;

public class Operator implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return (baseSalary);
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/EmployeePosition.java
```java
package com.company.Lab7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/Main.java
```java
package com.company.Lab7_8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int base_salary = 0;

        List<Employee> staff = new ArrayList<>();
        List<Employee> Sal = new ArrayList<>();
        Company comp = new Company();

        Manager mn = new Manager();
        Employee emp = new Employee("Manager", "Ivanov", 20000, mn);

        TopManager Tmn = new TopManager(comp);
        Employee emp1 = new Employee("TopManager", "Petrov", 200000, Tmn);

        comp.hire(emp);
        comp.hire(emp1);
        System.out.println("Доход компании с двумя работниками - " + comp.getIncome());

        for (int i = 0; i < 180; i++)
        {
            base_salary = 10000 + (int)(Math.random()*(10001));
            staff.add(new Employee("Ivan", "Petrov", base_salary, new Operator()));
        }
        for (int i = 0; i < 80; i++)
        {
            staff.add(new Employee("Manager", "Petrov", 100000, new Manager()));
        }
//        for (int i = 0; i < 5; i++)
//        {
//            staff.add(new Employee("Top", "Manager", 200000, new TopManager(comp)));
//        }
        comp.hireAll(staff);

        System.out.println("Доход компании - " + comp.getIncome());

        System.out.println("Топ 15 зарплат: ");
        Sal = comp.getTopSalaryStaff(15);
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calcSalary(Sal.get(i).getBase_salary()));
        Sal.clear();
        Sal = comp.getLowestSalaryStaff(30);
        System.out.println("Топ 30 минимальных зарплат: ");
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calcSalary(Sal.get(i).getBase_salary()));

        comp.fire(emp1);
        comp.fire_half();

        Sal.clear();
        System.out.println("Топ 15 зарплат: ");
        Sal = comp.getTopSalaryStaff(15);
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calcSalary(Sal.get(i).getBase_salary()));
        Sal.clear();
        Sal = comp.getLowestSalaryStaff(30);
        System.out.println("Топ 30 минимальных зарплат: ");
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calcSalary(Sal.get(i).getBase_salary()));
    }

}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/TopManager.java
```java
package com.company.Lab7_8;

public class TopManager implements EmployeePosition{

    Company info;

    public TopManager(Company info) {
        this.info = info;
    }

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double x;
        x = (info.getIncome() > 10000000) ? (baseSalary + baseSalary * 1.5) : baseSalary;
        return (x);
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/Company.java
```java
package com.company.Lab7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private int incom = 0;
    private List<Employee> staff = new ArrayList<>();


    public List<Employee> getTopSalaryStaff(int count)
    {
        List<Employee> TopSalAll = new ArrayList<>();
        List<Employee> TopSalCount = new ArrayList<>();
        TopSalAll.addAll(staff);
        Collections.sort(TopSalAll);
        if (count > TopSalAll.size() || count < 0)
            count = TopSalAll.size();
        for (int i = 0; i < count; i++) {
            TopSalCount.add(TopSalAll.get(i));
        }
        return (TopSalCount);
    }

    public List<Employee> getLowestSalaryStaff(int count)
    {
        List<Employee> TopSalAll = new ArrayList<>();
        List<Employee> TopSalCount = new ArrayList<>();
        TopSalAll.addAll(staff);
        Collections.sort(TopSalAll);
        if (count > TopSalAll.size() || count < 0)
            count = TopSalAll.size();
        for (int i = TopSalAll.size(); i > TopSalAll.size() - count; i--) {
            TopSalCount.add(TopSalAll.get(i - 1));
        }
        return (TopSalCount);
    }

    public void hire(Employee st)
    {
        staff.add(st);
    }
    public void hireAll(List <Employee> st)
    {
        staff.addAll(st);
    }
    void fire(Employee person)
    {
        staff.remove(person);
    }
    void fire_half()
    {
        for (int i = 0; i < staff.size() /2; i++) {
            fire(staff.get(i));
        }
    }
    int getIncome()
    {
        for (int i = 0; i < staff.size(); i++)
        {
            if (staff.get(i).getPosition() instanceof Manager)
            {
                Manager ch = (Manager) staff.get(i).getPosition();
                incom += ch.GetIn();
            }
        }
        return incom;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab7_8/Employee.java
```java
package com.company.Lab7_8;

public class Employee implements Comparable<Employee> {
    private String name, surname;
    private double base_salary;
    private EmployeePosition position;

    public double getBase_salary() {
        return base_salary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public Employee(String name, String surname, int base_salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.base_salary = base_salary;
        this.position = position;
    }

    @Override
    public int compareTo(Employee o) {
        double a = this.position.calcSalary(this.base_salary);
        double b = o.getPosition().calcSalary(o.getBase_salary());
        if (a < b)
            return (1);
        else if (a > b)
            return (-1);
        else
            return 0;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab15_16/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab15_16/ListNode.java
```java
package com.company.Lab15_16;

public class ListNode<AnyType> {

    private ListNode pointers[] = new ListNode[2];
    private String command[] = new String[2];
    private int states[] = new int[2];

    public void set(int state, String command, ListNode pointer)
    {
        pointers[state] = pointer;
        this.command[state] = command;
        this.states[state] = state;
    }

    public ListNode[] getPointers() {
        return pointers;
    }

    public String[] getCommand() {
        return command;
    }

    public int[] getStates() {
        return states;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Test/Main.java
```java
//package com.company.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Rule {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
    public Rule(String a, String b) {
        this.a = a;
        this.b = b;
    }
}

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

        b = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < b; i++) {
            parse = sc.nextLine();
            s = parse.split(" ");
            Rules.add(new Rule(s[0], s[1]));
            rules2.put(s[0], s[1]);
        }


        currentStr = sc.nextLine();
        for (int i = 0; i < currentStr.length(); i++) {
            int flag = 0;
            for (int j = 0; j < b; j++) {
                if (i + Rules.get(j).getA().length() <= currentStr.length()) {
                    String key = currentStr.substring(i, i + Rules.get(j).getA().length());
                    if (Rules.get(j).getA().equals(key)) {
                        flag = 1;
                        to_out += Rules.get(j).getB();
                        i += Rules.get(j).getA().length() - 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                to_out += currentStr.charAt(i);
            }
        }

//        System.out.println("Без регулярного выражения: " + to_out);
        System.out.println(to_out);

        to_out = "";
        int index;
        for (int i = 0; i < b; i++) {
            to_out += Rules.get(i).getA();
            if (i != b - 1) {
                to_out += "|";
            }
        }
        Matcher m = Pattern.compile(to_out).matcher(currentStr);
//        System.out.println("Используя регулярное выражение: " + m.replaceAll(x -> rules2.get(x.group())));
//        System.out.println(m.replaceAll(x -> rules2.get(x.group())));
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab11/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab10/MySwingApp.java
```java
package com.company.Lab10;

import javax.swing.*;
import java.awt.*;

public class MySwingApp extends JFrame {
    private int clickCount = 0;
    public MySwingApp(){
        setTitle("My swing app!!!");
        setSize(350, 350);

        JLabel label = new JLabel("Enter First operand");
        JLabel label1 = new JLabel("Enter Second operand");
        JLabel label2 = new JLabel("Result");
        JTextField firstoperandfield = new JTextField();
        JTextField secondoperandfield = new JTextField();
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiplacation = new JButton("*");
        JButton division = new JButton("/");

        label.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);


        plus.addActionListener(action -> {
            try {
                int operand = Integer.parseInt(firstoperandfield.getText());
                int rez = operand + Integer.parseInt(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText("error");
            }
        });

        minus.addActionListener(action -> {
            try {
                int operand = Integer.parseInt(firstoperandfield.getText());
                int rez = operand - Integer.parseInt(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        division.addActionListener(action -> {
            try {
                double operand = Double.parseDouble(firstoperandfield.getText());
                double rez = operand / Double.parseDouble(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        multiplacation.addActionListener(action -> {
            try {
                double operand = Double.parseDouble(firstoperandfield.getText());
                double rez = operand * Double.parseDouble(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        JPanel panel = new JPanel();
        JPanel secondPanel = new JPanel();

        secondPanel.add(plus);
        secondPanel.add(minus);
        secondPanel.add(division);
        secondPanel.add(multiplacation);

        panel.setLayout(new GridLayout(6, 1));
        panel.add(label);
        panel.add(firstoperandfield);


        panel.add(label1);
        panel.add(secondoperandfield);
        panel.add(label2);
        panel.add(secondPanel);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab10/Main.java
```java
package com.company.Lab10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySwingApp app = new MySwingApp();
            app.setVisible(true);
        });
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/Movable.java
```java
package com.company.Lab5;

public interface Movable {
    void moveUp(double x);
    void moveDown(double x);
    void moveLeft(double y);
    void moveRight(double y);
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/MovableCircle.java
```java
package com.company.Lab5;

public class MovableCircle extends Circle implements Movable {

    private int x, y;
    public MovableCircle(double radius) {
        super(radius);
        x = 0;
        y =0;
    }

    @Override
    public void moveUp(double x) {
        this.x += x;
    }

    @Override
    public void moveDown(double x) {
        this.x -= x;
    }

    @Override
    public void moveLeft(double y) {
        this.y -= y;
    }

    @Override
    public void moveRight(double y) {
        this.y += y;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/MovableRectangle.java
```java
package com.company.Lab5;

public class MovableRectangle extends Rectangle implements Movable{
    MovablePoint upperLeft;
    MovablePoint downRight;

    public MovableRectangle(double width, double length) {
        super(width, length);
        upperLeft = new MovablePoint(0,0);
        downRight = new MovablePoint(width, length);
    }

    @Override
    public void setLength(double length) {
        downRight.moveRight(length - this.length);
        super.setLength(length);
    }

    @Override
    public void setWidth(double width) {
        downRight.moveDown(width - this.width);
        super.setWidth(width);
    }

    @Override
    public void moveUp(double x) {
        upperLeft.moveUp(x);
        downRight.moveUp(x);
    }

    @Override
    public void moveDown(double x) {
        upperLeft.moveDown(x);
        downRight.moveDown(x);
    }

    @Override
    public void moveLeft(double y) {
        upperLeft.moveLeft(y);
        downRight.moveLeft(y);
    }

    @Override
    public void moveRight(double y) {
        upperLeft.moveRight(y);
        downRight.moveRight(y);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "upperLeft=" + upperLeft +
                ", downRight=" + downRight +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/Circle.java
```java
package com.company.Lab5;

public class Circle extends Shape {
    protected double radius;

    Circle()
    {

    }
    Circle(double radius)
    {
        super("Black", false);
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/Rectangle.java
```java
package com.company.Lab5;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    Rectangle()
    {

    }
    Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    Rectangle(double width, double length)
    {
        super("Black", false);
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width * this.length;

    }

    @Override
    public double getPerimeter() {
        return this.width + this.length;
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/Main.java
```java
package com.company.Lab5;

public class Main {
    public static void main(String[] args) {
        MovableCircle Circle = new MovableCircle(5);
        System.out.println(Circle);
        Circle.moveDown(20);
        Circle.moveLeft(10);
        System.out.println(Circle);

        //2
        MovableRectangle Rect = new MovableRectangle(10, 20);
        System.out.println(Rect);
        Rect.moveLeft(10);
        System.out.println(Rect);
        Rect.moveDown(20);
        System.out.println(Rect);
        Rect.setWidth(30);
        System.out.println(Rect);
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/Shape.java
```java
package com.company.Lab5;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public abstract double getArea();
    public abstract double getPerimeter();
    Shape()
    {

    }
    Shape(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab5/MovablePoint.java
```java
package com.company.Lab5;

public class MovablePoint implements Movable {
    private double x, y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void moveUp(double x) {
        this.x += x;
    }

    @Override
    public void moveDown(double x) {
        this.x -= x;
    }

    @Override
    public void moveLeft(double y) {
        this.y -= y;
    }

    @Override
    public void moveRight(double y) {
        this.y += y;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/Book.java
```java
package com.company.Lab2;

public class Book {
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/dog_nursery.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/Main.java
```java
package com.company.Lab2;

public class Main {

    public static void main(String[] args) {
        Shape a = new Shape();
        a.length = 5;
        a.width = 10;
        a.toString();


        //last
        Dog b = new Dog();
        b.setAge(10);
        b.setName("Vanya");
        System.out.println(b.to_human());
        System.out.println(b.toString());
        dog_nursery c = new dog_nursery();
        c.add(b);

    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/Ball.java
```java
package com.company.Lab2;

public class Ball {
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/Dog.java
```java
package com.company.Lab2;

import java.security.spec.NamedParameterSpec;

public class Dog {
    int age;
    String name;

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return (this.age);
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return (this.name);
    }
    public int to_human()
    {
        return (age * 7);
    }

    @Override
    public String toString() {
        String s = "Возраст - " + age + " Кличка - " + name;
        return (s);
    }

    public Dog() {
        age = 0;
        name = "";
    }

}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab2/Shape.java
```java
package com.company.Lab2;

public class Shape {
    int length;
    int width;


    @Override
    public String toString() {
        System.out.println("Длина - " + length + " Ширина - " + width);
        return "";
    }
}


```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/BookTest.java
```java
package com.company.Lab3;

public class BookTest {
    public static void main(String[] args) {
        Book a = new Book();
        a.setName("Prikluzeniya_Elektronika");
        a.setYear(2000);
        System.out.println("Information:\nYear: " + a.GetYear() + "\nName: " + a.GetName() );
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/Circle.java
```java
package com.company.Lab3;

public class Circle {
    private int radius;
    private int length;
    private int square;

    public void setLength(int length) {
        this.length = length;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setSquare(int square) {
        this.square = square;
    }
    public int getLength() {
        return length;
    }
    public int getRadius() {
        return radius;
    }
    public int getSquare() {
        return square;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/Human.java
```java
package com.company.Lab3;

public class Human {

    private int Height;
    private String name;

    Head a;
    Leg b1;
    Leg b2;
    Hand c1;
    Hand c2;
    public Human(int height, String name, Head c, Leg a1, Leg a2, Hand b1, Hand b2)
    {
        this.Height = height;
        this.name = name;
        this.a = c;
        this.b1 = a1;
        this.b2 = a2;
        this.c1 = b1;
        this.c2 = b2;
    }
    public static class Head {
        private String hair_style;
        private String shape;

        Head(String hair_style, String shape)
        {
            this.hair_style = hair_style;
            this.shape = shape;
        }
        public void setHair_style(String hair_style) {
            this.hair_style = hair_style;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        public String getHair_style() {
            return hair_style;
        }

        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "hair_style='" + hair_style + '\'' +
                    ", shape='" + shape + '\'' +
                    '}';
        }
    }

    public static class Leg {
        private int length;

        Leg(int length) {
            this.length = length;
        }
        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Leg{" +
                    "length=" + length +
                    '}';
        }
    }

    public static class Hand {
        private String type_of_skin;

        Hand(String type_of_skin) {
            this.type_of_skin = type_of_skin;
        }
        public void setType_of_skin(String type_of_skin) {
            this.type_of_skin = type_of_skin;
        }

        public String getType_of_skin() {
            return type_of_skin;
        }

        @Override
        public String toString() {
            return "Hand{" +
                    "type_of_skin='" + type_of_skin + '\'' +
                    '}';
        }
    }

    public void setHeight(int height) {
        Height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Height=" + Height +
                ", name='" + name + '\'' +
                ", a=" + a +
                ", b1=" + b1 +
                ", b2=" + b2 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/Book.java
```java
package com.company.Lab3;

public class Book {
    private int Year;
    private String Name;

    public void setName(String name) {
        Name = name;
    }

    public void setYear(int year) {
        Year = year;
    }
    public int GetYear() {
        return Year;
    }
    public String GetName() {
        return Name;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/Main.java
```java
package com.company.Lab3;

public class Main {

    public static void main(String[] args) {
        Human.Hand a1 = new Human.Hand("Black");
        Human.Hand a2 = new Human.Hand("Black");
        Human.Leg b1 = new Human.Leg(20);
        Human.Leg b2 = new Human.Leg(21);
        Human.Head c = new Human.Head("Style", "Round");

        Human j = new Human(190, "alex", c, b1, b2, a1, a2);
        System.out.println(j.toString());
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab3/CircleTest.java
```java
package com.company.Lab3;

public class CircleTest {
    public static void main(String[] args) {
        Circle a = new Circle();

        a.setLength(1);
        a.setRadius(2);
        a.setSquare(10);

        System.out.println(a.getLength());
        System.out.println(a.getRadius());
        System.out.println(a.getSquare());

    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab4/Circle.java
```java
package com.company.Lab4;

public class Circle extends Shape {
    protected double radius;
    Circle()
    {

    }
    Circle(double radius)
    {
        super("Black", false);
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab4/Rectangle.java
```java
package com.company.Lab4;

public class Rectangle extends Shape{
    protected double width;
    protected double length;

    Rectangle()
    {

    }
    Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    Rectangle(double width, double length)
    {
        super("Black", false);
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width * this.length;

    }

    @Override
    public double getPerimeter() {
        return this.width + this.length;
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab4/Main.java
```java
package com.company.Lab4;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Circle cr = new Circle(2);
        Rectangle rc = new Rectangle(1, 2, "Red", true);
        Square sq = new Square(3);
        System.out.println(cr.toString());
        System.out.println(sq.toString());
        System.out.println(rc.toString());

    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab4/Square.java
```java
package com.company.Lab4;

public class Square extends Shape {
    private double side;

    Square() {}
    Square(double side) {
        super("Black", false);
        this.side = side;
    }

    Square(double side, String color, boolean filled)
    {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side + this.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab4/Shape.java
```java
package com.company.Lab4;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public abstract double getArea();
    public abstract double getPerimeter();
    Shape()
    {

    }
    Shape(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Add/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab12/Enums.java
```java
package com.company.Lab12;

public enum Enums {
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String field;

    Enums(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab12/Main.java
```java
package com.company.Lab12;

public class Main {

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        color("1", Enums.BLACK);
        color("2", Enums.RED);
        color("3", Enums.GREEN);
        color("4", Enums.YELLOW);
        color("5", Enums.BLUE);
        color("6", Enums.MAGENTA);
        color("7", Enums.CYAN);
        color("8", Enums.WHITE);
    }

    public static void color(String s, Enums a) {
        System.out.println(a.getField() + s + RESET);
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab13/MyRunTimeException.java
```java
package com.company.Lab13;

public class MyRunTimeException extends RuntimeException {
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab13/MineException.java
```java
package com.company.Lab13;

public class MineException extends IllegalArgumentException {
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab13/Main.java
```java
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab13/SmthThatThrowException.java
```java
package com.company.Lab13;

public class SmthThatThrowException {
    private int a = 0;
    private int b = 0;
    private int c = 0;

    public void addA(int a) throws Exception {
        if (a < 0)
            throw new Exception();
        this.a += a;
    }

    public void checkMyexception(int a) throws MineException {
        if (a < 0)
            throw new MineException();
        this.b += a;
    }

    public void checkMyRuntime(int a) throws MyRunTimeException {
        if (a < 0)
            throw new MyRunTimeException();
        this.c += a;
    }

    @Override
    public String toString() {
        return "SmthThatThrowException{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab14/Main.java
```java
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

        b = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < b; i++) {
            //sc = new Scanner(System.in);
            parse = sc.nextLine();
            s = parse.split(" ");
            Rules.add(new Rule(s[0], s[1]));
            rules2.put(s[0], s[1]);
        }


        //sc = new Scanner(System.in);
        currentStr = sc.nextLine();
        for (int i = 0; i < currentStr.length(); i++) {
            int flag = 0;
            for (int j = 0; j < b; j++) {
                if (i + Rules.get(j).getA().length() <= currentStr.length()) {
                    String key = currentStr.substring(i, i + Rules.get(j).getA().length());
                    if (Rules.get(j).getA().equals(key)) {
                        flag = 1;
                        to_out += Rules.get(j).getB();
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
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab14/Rule.java
```java
package com.company.Lab14;

public class Rule {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
    public Rule(String a, String b) {
        this.a = a;
        this.b = b;
    }
}
```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/ThreadAdd/Main.java
```java
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

```
##### /Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/com/company/Lab17_18/Main.java
```java
package com.company.Lab17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static PrintWriter pw;
    static void getInfo(String path) {
        File file = new File(path);
        if(file.isDirectory()){
            String[] contents = file.list();
            for (String s:contents) {
                getInfo(path + "/" +s);
            }
        }
        if(file.isFile() ) {
            if (file.getName().endsWith(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    pw.write("##### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        pw.write(line + "\n");
                        line = reader.readLine();
                    }
                    pw.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) {
        Path filePath = Paths.get("").toAbsolutePath();
        try {
            pw = new PrintWriter("AllWorks.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getInfo(filePath.toString()+"/src");
        pw.close();
    }

}
```
