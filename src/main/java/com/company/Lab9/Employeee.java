package com.company.Lab9;

import java.time.LocalDate;

public class Employeee {
    private LocalDate ld;
    private String name, surname;
    private String placeOfLiving;
    private String phoneNumber;
    private int salary;

    public Employeee(LocalDate ld, String name, String surname, String placeOfLiving, String phoneNumber, int salary) {
        this.ld = ld;
        this.name = name;
        this.surname = surname;
        this.placeOfLiving = placeOfLiving;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public LocalDate getLd() {
        return ld;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "ld=" + ld +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", placeOfLiving='" + placeOfLiving + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
