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

import java.math.BigDecimal;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @InjectMocks
    PaymentController paymentController;

    @Mock
    PaymentService paymentService;

    @Mock
    PaymentRequest requestDto;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController)
                .alwaysDo(print())
                .build();
        objectMapper = new ObjectMapper();

        requestDto = new PaymentRequest();
        requestDto.setPaymentMethod("Debito");
        requestDto.setCustomer_id(12345L);
        requestDto.setDescription("Pagamento de Fatura");
        requestDto.setValue(BigDecimal.valueOf(10.0));
        requestDto.setDebt_id(123L);

        paymentController = Mockito.mock(PaymentController.class);

    }


    @Test
    void whenCreatingAPaymentShouldReturnHttpStatus201() throws Exception {
        mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void whenCallingControllerWithInvalidRequestBody_ShouldReturnBadRequest400() throws Exception {
        PaymentRequest request = new PaymentRequest();
        mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString("request")))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void findAllPayments() throws Exception {
        mockMvc.perform(get("/payment")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}