package com.rmatejak.braintri.repository;

import com.rmatejak.braintri.persistence.entity.Profession;
import com.rmatejak.braintri.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Long countByProfession(Profession profession);
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAllByOrderByName();
    List<UserEntity> findAllByOrderBySurname();
    List<UserEntity> findAllByOrderByEmail();
    UserEntity findByEmail(String email);
}
