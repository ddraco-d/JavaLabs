package com.company.Lab7_8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> staff = new ArrayList<>();
        Company comp = new Company();

        Manager mn = new Manager();
        Employee emp = new Employee("Ivan", "Ivanov", 20000, mn);

        TopManager Tmn = new TopManager(comp);
        Employee emp1 = new Employee("Ivan", "Petrov", 20000, Tmn);

        comp.hire(emp);
        comp.hire(emp1);
        System.out.println(comp.getIncome());

        for (int i = 0; i < 180; i++)
        {
            staff.add(new Employee("Ivan", "Petrov", 20000, new Operator()));
        }
        for (int i = 0; i < 80; i++)
        {
            staff.add(new Employee("Ivan", "Petrov", 20000, new Manager()));
        }
        for (int i = 0; i < 10; i++)
        {
            staff.add(new Employee("Ivan", "Petrov", 20000, new TopManager(comp)));
        }
        comp.hireAll(staff);

        System.out.println(comp.getIncome());
    }

}
