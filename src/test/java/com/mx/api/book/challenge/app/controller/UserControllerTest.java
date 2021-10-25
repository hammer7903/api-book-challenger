package com.mx.api.book.challenge.app.controller;

import com.mx.api.book.challenge.app.constant.Messages;
import com.mx.api.book.challenge.app.model.dto.request.UserRequest;
import com.mx.api.book.challenge.app.model.dto.response.ResponseWrapper;
import com.mx.api.book.challenge.app.model.dto.response.UserResponseDTO;
import com.mx.api.book.challenge.app.service.GeneraResponseService;
import com.mx.api.book.challenge.app.service.UserService;
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

import static org.mockito.Mockito.when;

class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private GeneraResponseService generaResponseService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @SuppressWarnings("unchecked")
    @Test
    public <T> void getCreditCalculateTest() throws Exception {
        UserRequest userRequest = UtilTest.getUserRequest("createUserRequest.json");
        UserResponseDTO userResponseDTO = UtilTest.getUserResponseDTO("createUserResponse.json");
        ResponseWrapper respuestaServicio = new ResponseWrapper();
        respuestaServicio.setStatus(0);
        respuestaServicio.setMessage(Messages.MSG_SUCCESS);
        respuestaServicio.setData(userResponseDTO);

        when(userService.createUser(userRequest)).thenReturn(userResponseDTO);
        when(generaResponseService.buildResponse(userResponseDTO)).thenReturn(respuestaServicio);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/sign-up").content(UtilTest.asJsonString(userRequest))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assert mvcResult.getResponse().getStatus() == 200;
    }
}