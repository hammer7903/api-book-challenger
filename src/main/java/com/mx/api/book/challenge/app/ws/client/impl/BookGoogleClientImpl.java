package com.mx.api.book.challenge.app.ws.client.impl;

import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;
import com.mx.api.book.challenge.app.ws.client.BookGoogleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class BookGoogleClientImpl implements BookGoogleClient {

    private final  RestTemplate restTemplate;
    @Value("${url.google.book}")
    private String urlGoogleBook;
    @Override
    public BookGoogle findBooksGoogleByTitle(String title) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(urlGoogleBook)
                .queryParam("q", title);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<BookGoogle> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                BookGoogle.class
        );
        return responseEntity.getBody();
    }
}
