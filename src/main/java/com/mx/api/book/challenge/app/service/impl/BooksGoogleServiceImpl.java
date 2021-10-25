package com.mx.api.book.challenge.app.service.impl;

import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;
import com.mx.api.book.challenge.app.service.BooksGoogleService;
import com.mx.api.book.challenge.app.ws.client.BookGoogleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksGoogleServiceImpl implements BooksGoogleService {

    private final BookGoogleClient bookGoogleClient;
    @Override
    public BookGoogle findBooksGoogleByTitle(String title) {
        return bookGoogleClient.findBooksGoogleByTitle(title);
    }
}
