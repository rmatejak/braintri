package com.rmatejak.braintri.service;

import com.rmatejak.braintri.persistence.dto.UserFormDto;
import com.rmatejak.braintri.persistence.entity.Profession;
import com.rmatejak.braintri.persistence.view.UserViewDto;

import java.util.List;

public interface UserService {
    void addUser(UserFormDto userFormDto);
    void deleteUser(Long id);
    List<UserViewDto> getUsersByName();
    List<UserViewDto> getUsersBySurname();
    List<UserViewDto> getUsersByEmail();
    Long countByProfession(Profession profession);
}
