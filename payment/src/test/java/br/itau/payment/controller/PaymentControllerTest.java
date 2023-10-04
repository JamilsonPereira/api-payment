package br.itau.payment.controller;

import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {
//
//    @InjectMocks
//    PaymentController paymentController;
//
//    @Mock
//    PaymentService paymentService;
//
//    @Mock
//    PaymentRequest requestDto;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void setup() {
//        initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(paymentController)
//                .alwaysDo(print())
//                .build();
//        objectMapper = new ObjectMapper();
//        requestDto = new PaymentRequest();
//
//        paymentController = Mockito.mock(PaymentController.class);
//        char[][] matriz = {
//                {'r', 'a', 'c', 'e'},
//                {'a', 'b', 'o', 'a'},
//                {'c', 'o', 'l', 'd'},
//                {'e', 'a', 'a', 'r'}
//        };
//        requestDto.setMatriz(matriz);
//    }
//
//
//    @Test
//    void aoAdicionarAlistaDeArraysCorretamenteDeveRetornarHttpStatus201() throws Exception {
//        mockMvc.perform(post("/palindromo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(requestDto)))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//
//    @Test
//    void aoChamarControladorComCorpoDeRequisiçãoInválido_DeveRetornarBadRequest400() throws Exception {
//        PaymentRequest request = new PaymentRequest();
//        mockMvc.perform(post("/palindromo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString("request")))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    void buscarPalindromosGerados() throws Exception {
//        mockMvc.perform(get("/palindromo")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}