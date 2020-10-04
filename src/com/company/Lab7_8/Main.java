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
