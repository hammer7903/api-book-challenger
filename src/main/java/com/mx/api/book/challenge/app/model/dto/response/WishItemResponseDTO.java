package com.mx.api.book.challenge.app.model.dto.response;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Generated
@Builder
@Getter
@Setter
public class WishItemResponseDTO implements ResponseDTO{
    private List<WishItemDetail> listWishItem;
}