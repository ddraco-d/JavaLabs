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
