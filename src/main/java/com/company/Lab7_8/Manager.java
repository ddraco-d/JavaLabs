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
