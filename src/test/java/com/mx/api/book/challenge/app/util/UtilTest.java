package com.mx.api.book.challenge.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.api.book.challenge.app.model.dto.google.book.BookGoogle;
import com.mx.api.book.challenge.app.model.dto.google.book.response.BookGoogleResponseDTO;
import com.mx.api.book.challenge.app.model.dto.request.UserRequest;
import com.mx.api.book.challenge.app.model.dto.response.ResponseVoidDTO;
import com.mx.api.book.challenge.app.model.dto.response.UserResponseDTO;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {



    public static String rendingOfDocuments(String fileName) {
        Object file;
        String response = null;
        JSONParser parser = new JSONParser();

        URL fileLocalitation = UtilTest.class.getClassLoader().getResource(fileName);
        try {
            file = parser.parse(new FileReader(fileLocalitation.getFile()));
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(file);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRequest getUserRequest(String fileName) {
        UserRequest userRequest = null;
        String responseString = UtilTest.rendingOfDocuments(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            userRequest = mapper.readValue(responseString, new TypeReference<UserRequest>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userRequest;
    }
    public static UserResponseDTO getUserResponseDTO(String fileName) {
        UserResponseDTO userResponseDTO = null;
        String responseString = UtilTest.rendingOfDocuments(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            userResponseDTO = mapper.readValue(responseString, new TypeReference<UserResponseDTO>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userResponseDTO;
    }

    public static ResponseVoidDTO getResponseVoidDTO(String fileName) {
        ResponseVoidDTO responseVoidDTO = null;
        String responseString = UtilTest.rendingOfDocuments(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            responseVoidDTO = mapper.readValue(responseString, new TypeReference<ResponseVoidDTO>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return responseVoidDTO;
    }

    public static BookGoogle getBookGoogle(String fileName) {
        BookGoogle bookGoogle = null;
        String responseString = UtilTest.rendingOfDocuments(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            bookGoogle = mapper.readValue(responseString, new TypeReference<BookGoogle>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bookGoogle;
    }

    public static BookGoogleResponseDTO getBookGoogleResponseDTO(String fileName) {
        BookGoogleResponseDTO bookGoogleResponseDTO = null;
        String responseString = UtilTest.rendingOfDocuments(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            bookGoogleResponseDTO = mapper.readValue(responseString, new TypeReference<BookGoogleResponseDTO>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bookGoogleResponseDTO;
    }



}
