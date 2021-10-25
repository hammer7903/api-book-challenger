package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.UserRequest;
import com.mx.api.book.challenge.app.model.dto.response.UserResponseDTO;
import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.repository.UserRepository;
import com.mx.api.book.challenge.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncode;
    @Override
    public UserResponseDTO createUser(UserRequest userRequest)throws ExamenException {
        UserEntity user = new UserEntity();
        UserEntity userDb = userRepository.findByUsername(userRequest.getUserName());
        if(Objects.nonNull(userDb)){
            throw new ExamenException("Favor de registrar con otras credenciales.\n El usuario ya existe.", HttpStatus.CONFLICT);
        }
        user.setUsername(userRequest.getUserName());
        user.setPassword(passwordEncode.encode(userRequest.getPwd()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return UserResponseDTO.builder().userName(userRequest.getUserName()).build();
    }


}
