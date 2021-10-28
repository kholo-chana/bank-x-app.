package com.Kholofelo.practice;

public class Employee {

    private String name;
    private int age;
    private int yearOfExp;

    public Employee() {
    }

    public Employee(String name, int age, int yearOfExp) {
        this.name = name;
        this.age = age;
        this.yearOfExp = yearOfExp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }
}
