package com.rmatejak.braintri.persistence.entity;

import lombok.Getter;

@Getter
public enum Profession {
    EMPLOYEE("EMPLOYEE"),
    MANAGER("MANAGER"),
    DIRECTOR("DIRECTOR");

    private String value;

    Profession(String value) { this.value = value; }
}
