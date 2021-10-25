package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.CodesHttp;
import com.mx.api.book.challenge.app.constant.SwaggerMessage;
import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.request.CreateWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.request.DeleteWishItemRequest;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseVoidDTO;
import com.mx.api.book.challenge.app.model.dto.response.WishItemResponseDTO;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import com.mx.api.book.challenge.app.service.WishItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Validated
@Slf4j
public class WishItemController {
    private final WishItemService wishItemService;
    private final GeneraResponseService generaResponseService;

    @ApiOperation(notes = SwaggerMessage.CREATE_WISH_ITEM_SWAGGER,
            value = SwaggerMessage.CREATE_WISH_ITEM_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "wish-list/item")
    @ResponseBody
    public ResponseEntity<ResponseDTO> createWishItem(@RequestBody @Valid CreateWishItemRequest wishItemRequest) throws ExamenException {
        log.info("Inicia metodo WishItemController.createWishItem()...");
        wishItemService.createWishItem(wishItemRequest);
        log.info("Termina metodo WishItemController.createWishItem()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(ResponseVoidDTO.builder().build()), OK);
    }

    @ApiOperation(notes = SwaggerMessage.DELETE_WISH_ITEM_SWAGGER,
            value = SwaggerMessage.DELETE_WISH_ITEM_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping(value = "wish-list/item")
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteWishItem(@RequestBody @Valid DeleteWishItemRequest deleteWishItemRequest) throws ExamenException {
        log.info("Inicia metodo WishItemController.deleteWishItem()...");
       wishItemService.deleteWishItem(deleteWishItemRequest);
        log.info("Termina metodo WishItemController.deleteWishItem()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(ResponseVoidDTO.builder().build()), OK);
    }

    @ApiOperation(notes = SwaggerMessage.GET_WISH_ITEM_SWAGGER,
            value = SwaggerMessage.GET_WISH_ITEM_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "wish-list/item/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> getWishListByUsername(@PathVariable(name="id") Integer idWishList) throws ExamenException {
        log.info("Inicia metodo WishItemController.getWishListByUsername()...");
        WishItemResponseDTO wishItemResponseDTO = wishItemService.getWishItemByWishList(idWishList);
        log.info("Termina metodo WishItemController.getWishListByUsername()...");
        return new ResponseEntity<>(generaResponseService.buildResponse(wishItemResponseDTO), OK);
    }
}

