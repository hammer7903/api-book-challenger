package com.mx.api.book.challenge.app.service;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.UserRequest;
import com.mx.api.book.challenge.app.model.dto.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequest userRequest)throws ExamenException;

}
