package com.mx.api.book.challenge.app.service;


import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseWrapper;

public interface GeneraResponseService {

    <T> ResponseWrapper buildResponse(ResponseDTO responseObj) ;
}
