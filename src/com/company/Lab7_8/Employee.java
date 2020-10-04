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
