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
