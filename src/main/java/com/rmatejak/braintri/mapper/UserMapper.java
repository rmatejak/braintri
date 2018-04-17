package com.rmatejak.braintri.mapper;

import com.rmatejak.braintri.persistence.dto.UserFormDto;
import com.rmatejak.braintri.persistence.entity.UserEntity;
import com.rmatejak.braintri.persistence.view.UserViewDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity map(UserFormDto userFormDto);
    List<UserViewDto> map(Collection<UserEntity> users);
}
