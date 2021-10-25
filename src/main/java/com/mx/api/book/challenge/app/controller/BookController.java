package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.CodesHttp;
import com.mx.api.book.challenge.app.constant.SwaggerMessage;
import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.google.book.response.BookGoogleResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import com.mx.api.book.challenge.app.service.BooksGoogleService;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Validated
@Slf4j
public class BookController {

    private final BooksGoogleService booksGoogleService;
    private final GeneraResponseService generaResponseService;

    @ApiOperation(notes = SwaggerMessage.API_GOOGLE_SWAGGER,
            value = SwaggerMessage.API_GOOGLE_SWAGGER,
            response = UserController.class)
    @ApiResponses(value = {
            @ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS,
                    response = UserController.class),
            @ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
            @ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
            @ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
            @ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE)})
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "books/search")
    @ResponseBody
    public ResponseEntity<ResponseDTO> getBookByTitle(@RequestParam(name = "title") String title) throws ExamenException {
        log.info("Inicia metodo BookController.getBookByTitle()...");
        BookGoogleResponseDTO bookGoogleResponseDTO = new BookGoogleResponseDTO();
        bookGoogleResponseDTO.setBookGoogle(booksGoogleService.findBooksGoogleByTitle(title));
        return new ResponseEntity<>(generaResponseService.buildResponse(bookGoogleResponseDTO), OK);
    }
}
