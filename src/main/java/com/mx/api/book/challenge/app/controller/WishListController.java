package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.CodesHttp;
import com.mx.api.book.challenge.app.constant.SwaggerMessage;
import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseVoidDTO;
import com.mx.api.book.challenge.app.model.dto.response.WishListResponseDTO;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import com.mx.api.book.challenge.app.service.WishListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Validated
@Slf4j
public class WishListController {

    private final WishListService wishListService;
    private final GeneraResponseService generaResponseService;

    @ApiOperation(notes = SwaggerMessage.CREATE_WISH_LIST_SWAGGER,
            value = SwaggerMessage.CREATE_WISH_LIST_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "wish-list/{nameList}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> createWishList(@PathVariable (name = "nameList") String nameList, Authentication authentication) throws ExamenException {
        log.info("Inicia metodo WishListController.createWishList()...");
        String username = authentication.getName();
        wishListService.createListWishList(nameList,username);
        log.info("Termina metodo WishListController.createWishList()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(ResponseVoidDTO.builder().build()), OK);
    }

    @ApiOperation(notes = SwaggerMessage.GET_WISH_LIST_SWAGGER,
            value = SwaggerMessage.GET_WISH_LIST_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "wish-list")
    @ResponseBody
    public ResponseEntity<ResponseDTO> getWishListByUsername(Authentication authentication) throws ExamenException {
        log.info("Inicia metodo WishListController.getWishListByUsername()...");
        String username = authentication.getName();
        WishListResponseDTO wishListResponseDTO = wishListService.getWishLisByUsername(username);
        log.info("Termina metodo WishListController.getWishListByUsername()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(wishListResponseDTO), OK);
    }

    @ApiOperation(notes = SwaggerMessage.DELETE_WISH_LIST_SWAGGER,
            value = SwaggerMessage.DELETE_WISH_LIST_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping(value = "wish-list/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteWishList(@PathVariable (name = "id") Integer idWishList) throws ExamenException {
        log.info("Inicia metodo WishListController.deleteWishList()...");
        wishListService.deleteWishList(idWishList);
        log.info("Termina metodo WishListController.deleteWishList()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(ResponseVoidDTO.builder().build()), OK);
    }
}
