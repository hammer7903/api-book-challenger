package com.mx.api.book.challenge.app.repository;

import com.mx.api.book.challenge.app.model.entity.WishItemEntity;
import com.mx.api.book.challenge.app.model.entity.WishListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishItemRepository extends CrudRepository<WishItemEntity, Integer> {

    WishItemEntity findByWishListAndIdBook(WishListEntity wishList, String idBook);
    List<WishItemEntity> findByWishList(WishListEntity wishList);
}
