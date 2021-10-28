package com.Kholofelo.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class EmployeeManagementSystem {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeManagementSystem.class, args);

        // Calling EmployeeRecord class by creating object of that class.
		EmployeeRecord empData = new EmployeeRecord();

        // Call employeeRecord() method using reference variable data.
		ArrayList<Employee> employees = empData.employeeRecord();


       // Now iterating and display all the Employee data.
		employees.forEach(emp -> {
			System.out.println("Name : " + emp.getName());
			System.out.println("Age : " + emp.getAge());
			System.out.println("Year of Exp :" +emp.getYearOfExp());
			System.out.println("==================================");
		});
	}
}