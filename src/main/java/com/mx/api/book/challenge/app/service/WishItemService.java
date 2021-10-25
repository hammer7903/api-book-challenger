package com.mx.api.book.challenge.app.service;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.CreateWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.request.DeleteWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.response.WishItemResponseDTO;

public interface WishItemService {

    void createWishItem(CreateWishItemRequest wishItemRequest)throws ExamenException ;
    void deleteWishItem(DeleteWishItemRequest deleteWishItemRequest)throws ExamenException;
    WishItemResponseDTO getWishItemByWishList(Integer idWishList)throws ExamenException;
}
