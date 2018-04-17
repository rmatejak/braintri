package com.rmatejak.braintri.service;

import com.google.common.base.Preconditions;
import com.rmatejak.braintri.mapper.UserMapper;
import com.rmatejak.braintri.mapper.UserMapperImpl;
import com.rmatejak.braintri.persistence.dto.UserFormDto;
import com.rmatejak.braintri.persistence.entity.Profession;
import com.rmatejak.braintri.persistence.entity.UserEntity;
import com.rmatejak.braintri.persistence.view.UserViewDto;
import com.rmatejak.braintri.repository.UserRepository;
import com.rmatejak.braintri.validation.ValidationException;
import com.rmatejak.braintri.validation.ValidationMessage;
import com.rmatejak.braintri.validation.ValidationPredicates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final static UserMapper usermapper = new UserMapperImpl();

    @Override
    public void addUser(UserFormDto userFormDto) {
        Preconditions.checkNotNull(userFormDto, "New User cannot be NULL");
        ValidationPredicates.lenght(2, 30, userFormDto.getName(), ValidationMessage.NAME_SIZE_NOT_CORRECT);
        ValidationPredicates.lenght(2, 50, userFormDto.getSurname(), ValidationMessage.SURNAME_SIZE_NOT_CORRECT);
        isUserExistByEmail(userFormDto.getEmail(), ValidationMessage.USER_EXIST_BY_EMAIL);
        ValidationPredicates.lenght(10, 50, userFormDto.getEmail(), ValidationMessage.EMAIL_SIZE_NOT_CORRECT);
        ValidationPredicates.emailMatcher(userFormDto.getEmail(), ValidationMessage.EMAIL_MATCH_NOT_CORRECT);
        UserEntity userEntity = usermapper.map(userFormDto);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        isUserExistById(id, ValidationMessage.USER_NOT_EXIST_BY_ID);
        userRepository.deleteById(id);
    }

    @Override
    public List<UserViewDto> getUsersByName() {
        List<UserEntity> listofusers = userRepository.findAllByOrderByName();
        return usermapper.map(listofusers);
    }

    @Override
    public List<UserViewDto> getUsersBySurname() {
        List<UserEntity> listofusers = userRepository.findAllByOrderBySurname();
        return usermapper.map(listofusers);
    }

    @Override
    public List<UserViewDto> getUsersByEmail() {
        List<UserEntity> listofusers = userRepository.findAllByOrderByEmail();
        return usermapper.map(listofusers);
    }

    @Override
    public Long countByProfession(Profession profession) {
        return userRepository.countByProfession(profession);
    }

    private void isUserExistByEmail(String email, ValidationMessage message) {
        if (userRepository.findByEmail(email) != null) {
            throw new ValidationException(message);
        }
    }

    private void isUserExistById(Long id, ValidationMessage message) {
        userRepository.findById(id).orElseThrow(() -> new ValidationException(message));
    }
}
