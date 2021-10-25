package com.mx.api.book.challenge.app.advices;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.mx.api.book.challenge.app.exception.ExamenException;
import com.mx.api.book.challenge.app.model.dto.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase personalizada para el manejo de Exceptiones
 */
@ControllerAdvice
public class ControllerAdvisor {

    /**
     * Metodo que contiene la exception generica que sera interseptada cuando esta
     * exception se lance
     *
     * @param ex Exception generica
     * @return ResponseEntity<Object> con el objeto Creado en base a la Exception
     */
    @ExceptionHandler(ExamenException.class)
    public ResponseEntity<Object> handleException(ExamenException ex) {
        ResponseWrapper wra = new ResponseWrapper();
        wra.setStatus(ex.getStatus().value());
        wra.setMessage(ex.getMessage());

        return new ResponseEntity<>(wra, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationError(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrorMap = new HashMap<>();

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(fieldErrorMap, HttpStatus.BAD_REQUEST);
    }

}


