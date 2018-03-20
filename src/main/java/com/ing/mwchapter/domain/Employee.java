package com.ing.mwchapter.domain;

public class Employee extends Person {
    private final Double salary;
    private final Seniority seniority;

    public Employee(PersonId personId, String name, String surname, int age, Gender gender, Double salary, Seniority seniority) {
        super(personId, name, surname, age, gender);
        this.salary = salary;
        this.seniority = seniority;
    }

    public Double getSalary() {
        return salary;
    }

    public Seniority getSeniority() {
        return seniority;
    }
}
