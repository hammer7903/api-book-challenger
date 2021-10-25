package com.mx.api.book.challenge.app.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO implements ResponseDTO, Serializable {
    /**
     * Serializacion de la clase
     */
    private static final long serialVersionUID = 1L;

    String userName;
}
