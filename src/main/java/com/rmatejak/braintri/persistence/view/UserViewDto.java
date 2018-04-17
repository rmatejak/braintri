package com.rmatejak.braintri.persistence.view;

import com.rmatejak.braintri.persistence.entity.Profession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserViewDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Profession profession;
}
