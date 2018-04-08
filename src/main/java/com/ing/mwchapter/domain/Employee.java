package com.ing.mwchapter.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Getter
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

}
