package com.rmatejak.braintri.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Getter
@Setter
@Entity
@Table(name = "USER")
@RequiredArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "NAME",nullable = false, length = 30)
    private String name;
    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;
    @Email
    @Column(name = "EMAIL", nullable = false, length = 50, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "PROFESSION", nullable = false)
    private Profession profession;
}
