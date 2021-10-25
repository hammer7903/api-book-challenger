package com.mx.api.book.challenge.app.repository;

import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.model.entity.WishListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishListRepository extends CrudRepository<WishListEntity, Integer> {

    WishListEntity findByNameListAndUsername(String nameList, UserEntity Username);
    List<WishListEntity> findByUsername(UserEntity username);

}
