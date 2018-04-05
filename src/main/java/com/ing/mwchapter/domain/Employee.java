package com.ing.mwchapter.domain;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class Employee extends Person {
    private final Double salary;
    private final Seniority seniority;
    private final List<String> skills;

    public Employee(PersonId personId, String name, String surname, int age, Gender gender, Double salary, Seniority seniority, String... skills) {
        super(personId, name, surname, age, gender);
        this.salary = salary;
        this.seniority = seniority;
        this.skills = CollectionUtils.arrayToList(skills);
    }

    public Double getSalary() {
        return salary;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public List<String> getSkills() { return skills; }
}
