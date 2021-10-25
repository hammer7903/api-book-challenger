package com.mx.api.book.challenge.app.repository;

import com.mx.api.book.challenge.app.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
