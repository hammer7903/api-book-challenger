package com.mx.api.book.challenge.app.service;

import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;

public interface BooksGoogleService {

    BookGoogle findBooksGoogleByTitle(String title);
}
