package com.mx.api.book.challenge.app.model.dto.google.book.response;

import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;
import com.mx.api.book.challenge.app.model.dto.response.ResponseDTO;
import lombok.*;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookGoogleResponseDTO implements ResponseDTO {
    private BookGoogle bookGoogle;
}
