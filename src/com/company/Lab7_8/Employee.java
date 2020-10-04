package com.company.Lab7_8;

public class Employee{
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
}
