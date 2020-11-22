package com.company.Lab3;

public class BookTest {
    public static void main(String[] args) {
        Book a = new Book();
        a.setName("Prikluzeniya_Elektronika");
        a.setYear(2000);
        System.out.println("Information:\nYear: " + a.GetYear() + "\nName: " + a.GetName() );
    }
}
