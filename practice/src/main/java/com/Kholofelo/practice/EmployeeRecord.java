package com.Kholofelo.practice;

import java.util.ArrayList;

public class EmployeeRecord {

    // Create a ArrayList method of generic type 'Student'.
    ArrayList<Employee> employeeRecord()
    {
        Employee e1 = new Employee("Tiger Nixon", 40, 20);
        Employee e2 = new Employee("Jenette Caldwell", 23, 2);
        Employee e3 = new Employee("Doris Wilder", 45, 16);
        Employee e4 = new Employee("Caesar Vance", 37, 7);
        Employee e5 = new Employee("Rhona Davidson", 22, 1);
        Employee e6 = new Employee("Colleen Hurst", 45, 16);
        Employee e7 = new Employee("Michael Silva", 43, 13);
        Employee e8 = new Employee("Paul Byrd", 46, 15);
        Employee e9 = new Employee("Gloria Little", 39, 10);
        Employee e10 = new Employee("Brielle Williamson", 27, 7);


       // Create the object of ArrayList of generic type 'employee'.
        ArrayList<Employee> employees = new ArrayList<Employee>();

        //  adding Employee objects in the ArrayList using reference variable employees.
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);
        employees.add(e9);
        employees.add(e10);

        employees.sort((Employee emp1, Employee emp2)-> emp1.getAge()-emp2.getAge());

        return employees;
    }
}
