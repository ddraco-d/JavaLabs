package com.company.Lab9;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employeee> staff = new ArrayList<>();
    public void hire(Employeee st)
    {
        staff.add(st);
    }
    public void hireAll(List <Employeee> st)
    {
        staff.addAll(st);
    }
    void fire(Employeee person)
    {
        staff.remove(person);
    }

    void handle_employees(EmploySelector selector, EmpHandler handler) {
        int count = 0;
        for (Employeee employeee : staff) {
            if (selector.isNeedEmployee(employeee)) {
                handler.handleEmp(employeee, count);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "staff=" + staff +
                '}';
    }
}
