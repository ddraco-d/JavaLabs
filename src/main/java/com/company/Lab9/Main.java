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
