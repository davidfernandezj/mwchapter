package com.ing.mwchapter.domain;

import lombok.Getter;

@Getter
public class PersonId {
    private final String id;

    public PersonId(String id) {
        this.id = id;
    }

}
