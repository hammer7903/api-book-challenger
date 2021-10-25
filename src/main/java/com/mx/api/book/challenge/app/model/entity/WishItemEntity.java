package com.mx.api.book.challenge.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wish_item")
public class WishItemEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String idBook;
    private Integer cantidad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_wish_list", nullable = false)
    private WishListEntity wishList;
}
