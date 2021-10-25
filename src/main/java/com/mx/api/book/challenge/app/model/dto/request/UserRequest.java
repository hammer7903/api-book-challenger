package com.mx.api.book.challenge.app.model.dto.request;

import lombok.*;

import java.io.Serializable;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest implements Serializable {
    /**
     * Serializacion de la clase
     */
    private static final long serialVersionUID = 1L;

    private String userName;
    private String pwd;
}
