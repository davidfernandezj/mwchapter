package com.ing.mwchapter.domain;

import lombok.Getter;

@Getter
public class Person {
    private final PersonId personId;
    private final String name;
    private final String surname;
    private final int age;
    private final Gender gender;

    public Person(PersonId personId, String name, String surname, int age, Gender gender) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }
}
