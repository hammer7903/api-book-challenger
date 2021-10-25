package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.DeleteWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.response.WishListDetail;
import com.mx.api.book.challenge.app.model.dto.response.WishListResponseDTO;
import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.model.entity.WishListEntity;
import com.mx.api.book.challenge.app.repository.UserRepository;
import com.mx.api.book.challenge.app.repository.WishListRepository;
import com.mx.api.book.challenge.app.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    @Override
    public boolean createListWishList(String nameList, String username)throws ExamenException {
        boolean result = false;
        UserEntity userDb = userRepository.findByUsername(username);
        WishListEntity wishListEntityDb = wishListRepository.findByNameListAndUsername(nameList,userDb);
        if(Objects.nonNull(wishListEntityDb)){
            throw new ExamenException("El nombre de la lista ya existe.\n Favor de intentar con otro nombre.", HttpStatus.CONFLICT);
        }
        result = true;
        wishListRepository.save(WishListEntity.builder().nameList(nameList).username(userDb).build());
        return result;
    }

    @Override
    public void deleteWishList(Integer idWishList)throws ExamenException {
        var wishListEntityDb = wishListRepository.findById(idWishList);
        if(!wishListEntityDb.isPresent()){
            throw new ExamenException("La lista proporcionada no existe.\n Favor de validar.", HttpStatus.CONFLICT);
        }
        wishListRepository.delete(wishListEntityDb.get());
    }

    @Override
    public WishListResponseDTO getWishLisByUsername(String username)throws ExamenException {
        UserEntity userDb = userRepository.findByUsername(username);
        List<WishListEntity> wishListAll = wishListRepository.findByUsername(userDb);
        List<WishListDetail> wishListDetailList = new ArrayList<>();
        wishListAll.stream().forEach(o ->{
            wishListDetailList.add(WishListDetail.builder().nameList(o.getNameList()).id(o.getId()).build());
        });
        return WishListResponseDTO.builder().wishList(wishListDetailList).build();
    }
}
