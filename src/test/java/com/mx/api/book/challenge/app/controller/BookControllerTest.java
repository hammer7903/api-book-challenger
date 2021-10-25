package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.Messages;
import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;
import com.mx.api.book.challenge.app.model.dto.google.book.response.BookGoogleResponseDTO;
import com.mx.api.book.challenge.app.model.dto.response.ResponseWrapper;
import com.mx.api.book.challenge.app.service.BooksGoogleService;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import com.mx.api.book.challenge.app.util.UtilTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private GeneraResponseService generaResponseService;

    @Mock
    private BooksGoogleService booksGoogleService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }
    @SuppressWarnings("unchecked")
    @Test
    public <T> void getCreditCalculateTest() throws Exception {
        BookGoogle bookGoogle = UtilTest.getBookGoogle("bookGoogleResponse.json");
        BookGoogleResponseDTO bookGoogleResponseDTO = UtilTest.getBookGoogleResponseDTO("bookGoogleResponseDTO.json");
        ResponseWrapper respuestaServicio = new ResponseWrapper();
        respuestaServicio.setStatus(0);
        respuestaServicio.setMessage(Messages.MSG_SUCCESS);
        respuestaServicio.setData(bookGoogleResponseDTO);
        String title = "spring";

        when(booksGoogleService.findBooksGoogleByTitle(any())).thenReturn(bookGoogle);
        when(generaResponseService.buildResponse(bookGoogleResponseDTO)).thenReturn(respuestaServicio);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/books/search").queryParam("title",title)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assert mvcResult.getResponse().getStatus() == 200;
    }


}