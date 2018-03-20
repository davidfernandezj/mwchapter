package com.ing.mwchapter.domain;

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

    public PersonId getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
