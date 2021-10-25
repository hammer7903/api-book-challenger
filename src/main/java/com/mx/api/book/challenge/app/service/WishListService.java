package com.mx.api.book.challenge.app.service;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.response.WishListResponseDTO;

public interface WishListService {

    boolean createListWishList(String nameList,String username)throws ExamenException;
    WishListResponseDTO getWishLisByUsername(String username)throws ExamenException;
    void deleteWishList(Integer idWishList)throws ExamenException;
}
