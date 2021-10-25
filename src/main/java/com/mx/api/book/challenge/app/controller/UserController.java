package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.CodesHttp;
import com.mx.api.book.challenge.app.constant.SwaggerMessage;
import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.UserRequest;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import com.mx.api.book.challenge.app.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;



@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserController {

    private final GeneraResponseService generaResponseService;
    private final UserService userService;

    @ApiOperation(notes = SwaggerMessage.CREATE_USER_SWAGGER,
            value = SwaggerMessage.CREATE_USER_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PostMapping(value = "sign-up")
    @ResponseBody
    public ResponseEntity<ResponseDTO> createUserController(@RequestBody @Valid UserRequest userRequest) throws ExamenException {
        log.info("Inicia metodo UsuarioController.createUserController()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(userService.createUser(userRequest)), OK);
    }
}
