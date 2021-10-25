package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.model.entity.WishListEntity;
import com.mx.api.book.challenge.app.repository.UserRepository;
import com.mx.api.book.challenge.app.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WishListServiceImplTest {

    @Autowired
    private WishListServiceImpl wishListServiceImpl;

    @Mock
    private WishListRepository wishListRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createListWishListTest() {
        String nameList = "list1";
        String username = "jav";
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setRole("USER");
        user.setPassword("123");

        WishListEntity wishListEntity = new WishListEntity();
        wishListEntity.setId(1);
        wishListEntity.setUsername(user);
        wishListEntity.setNameList(nameList);

        WishListEntity wishListSave = new WishListEntity();
        wishListSave.setId(2);
        wishListSave.setUsername(user);
        wishListSave.setNameList(nameList);


        when(userRepository.findByUsername(username)).thenReturn(user);
        when(wishListRepository.findByNameListAndUsername(nameList,user)).thenReturn(wishListEntity);
        when(wishListRepository.save(any())).thenReturn(wishListSave);
      try{
            wishListServiceImpl.createListWishList(nameList,username);
      } catch (ExamenException ex) {
          assert ex.getMessage() != null;
      }

    }

}