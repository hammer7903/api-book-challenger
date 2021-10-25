package com.mx.api.book.challenge.app.exception;


import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ExamenException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -1L;


    private HttpStatus status;
    private String message;

    public ExamenException(Throwable cause) {
        super(cause);
    }

    public ExamenException(String message) {
        super(message);
    }

    public ExamenException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
