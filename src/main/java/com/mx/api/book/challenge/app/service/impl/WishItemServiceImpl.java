package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.CreateWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.request.DeleteWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.response.WishItemDetail;
import com.mx.api.book.challenge.app.model.dto.response.WishItemResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.WishListDetail;
import com.mx.api.book.challenge.app.model.dto.response.WishListResponseDTO;
import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.model.entity.WishItemEntity;
import com.mx.api.book.challenge.app.model.entity.WishListEntity;
import com.mx.api.book.challenge.app.repository.WishItemRepository;
import com.mx.api.book.challenge.app.repository.WishListRepository;
import com.mx.api.book.challenge.app.service.WishItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishItemServiceImpl implements WishItemService {
    private final WishListRepository wishListRepository;
    private final WishItemRepository  wishItemRepository;
    @Override
    public void createWishItem(CreateWishItemRequest wishItemRequest)throws ExamenException {
        var wishListEntity = wishListRepository.findById(wishItemRequest.getIdWishList());
        if(wishListEntity.isPresent()){
            var wishItemEntityDB = wishItemRepository.findByWishListAndIdBook(wishListEntity.get(),wishItemRequest.getIdBook());
             if(Objects.isNull(wishItemEntityDB)){
                 WishItemEntity wishItemEntity = new WishItemEntity();
                 wishItemEntity.setWishList(wishListEntity.get());
                 wishItemEntity.setCantidad(wishItemRequest.getCantidad());
                 wishItemEntity.setIdBook(wishItemRequest.getIdBook());
                 wishItemRepository.save(wishItemEntity);
             }else{
                 throw new ExamenException("El libro ya existe en su lista. \n Favor de validar.", HttpStatus.CONFLICT);
             }
          }else{
            throw new ExamenException("La lista no existe. \n Favor de validar.", HttpStatus.CONFLICT);
        }
    }

    @Override
    public void deleteWishItem(DeleteWishItemRequest deleteWishItemRequest)throws ExamenException {
        var wishListEntity = wishListRepository.findById(deleteWishItemRequest.getIdWishList());
        var wishItemEntityDB = wishItemRepository.findByWishListAndIdBook(wishListEntity.get(),deleteWishItemRequest.getIdBook());
        if(Objects.nonNull(wishItemEntityDB)){
            wishItemRepository.delete(wishItemEntityDB);
        }
    }

    @Override
    public WishItemResponseDTO getWishItemByWishList(Integer idWishList)throws ExamenException {
        var wishListEntity = wishListRepository.findById(idWishList);
        List<WishItemDetail> listWishItemDetail = new ArrayList<>();
        if(wishListEntity.isPresent()){
           List<WishItemEntity> listWishItemEntity = wishItemRepository.findByWishList(wishListEntity.get());

            listWishItemEntity.stream().forEach(o ->{
                listWishItemDetail.add(WishItemDetail.builder().id(o.getId()).cantidad(o.getCantidad())
                        .idBook(o.getIdBook()).build());
            });
        }else{
            throw new ExamenException("La lista no existe. \n Favor de validar.", HttpStatus.CONFLICT);
        }
        return WishItemResponseDTO.builder().listWishItem(listWishItemDetail).build();
    }
}
