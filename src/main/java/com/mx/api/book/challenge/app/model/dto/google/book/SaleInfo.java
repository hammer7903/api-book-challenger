package com.mx.api.book.challenge.app.model.dto.google.book; 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleInfo implements Serializable {
    private String country;
    private String saleability;
    private boolean isEbook;
    private ListPrice listPrice;
    private RetailPrice retailPrice;
    private String buyLink;
    private List<Offer> offers;
}
