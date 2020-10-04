package com.company.Lab7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private int incom = 0;
    private List<Employee> staff = new ArrayList<>();

//    public List<Employee> getTopSalaryStaff(int count)
//    {
//        List<Double> top = new ArrayList<Double>();
//        for (int i = 0; i < staff.size(); i++) {
//            top.add(staff.get(i).getPosition().calcSalary(staff.get(i).getBase_salary()));
//        }
//        Collections.sort(top);
//
//    }
//
//    public List<Employee> getLowestSalaryStaff(int count)
//    {
//
//    }

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
