package com.mx.api.book.challenge.app.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseWrapper implements ResponseDTO, Serializable {

    private static final long serialVersionUID = -1392954001929874570L;
    private int status;
    private String message;
    private ResponseDTO data;

}
