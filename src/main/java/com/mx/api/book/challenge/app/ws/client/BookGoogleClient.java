package com.mx.api.book.challenge.app.ws.client;

import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;

public interface BookGoogleClient {

    BookGoogle findBooksGoogleByTitle(String title);
}
