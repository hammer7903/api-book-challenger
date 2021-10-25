package com.mx.api.book.challenge.app.model.dto.google.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchInfo implements Serializable {
    private String textSnippet;
}
