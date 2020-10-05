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
