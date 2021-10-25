package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.constant.Messages;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseWrapper;

import com.mx.api.book.challenge.app.service.GeneraResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneraResponseServiceImpl implements GeneraResponseService {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ResponseWrapper buildResponse(ResponseDTO responseObj) {

        ResponseWrapper respuestaServicio = new ResponseWrapper();
        respuestaServicio.setStatus(0);
        respuestaServicio.setMessage(Messages.MSG_SUCCESS);
        respuestaServicio.setData(responseObj);

        return respuestaServicio;
    }
}
