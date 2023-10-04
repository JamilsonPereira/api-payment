package br.itau.payment.service;

import br.itau.payment.domain.Payment;
import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.dto.PaymentResponse;
import br.itau.payment.producer.KafkaProducer;
import br.itau.payment.repository.PaymentRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;

    @Mock
    PaymentRequest requestDto;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    Payment model;

    @Mock
    PaymentResponse paymentResponse;

    @Mock
    MapperService mapperService;

    @Mock
    KafkaProducer kafkaProducer;

    @BeforeEach
    void setUp() {
        initMocks(this);
        requestDto = new PaymentRequest();

        requestDto = new PaymentRequest();
        requestDto.setPaymentMethod("Debito");
        requestDto.setCustomer_id(12345L);
        requestDto.setDescription("Pagamento de Fatura");
        requestDto.setValue(BigDecimal.valueOf(10.0));
        requestDto.setDebt_id(123L);
    }


    @Test
    void checkIfPaymentInformationWasHandledCorrectlyAndIfKafkaMessageWasProduced() {
        String topic = "notifications.payment.request";

        paymentService.createPay(requestDto);
        Payment result = paymentRepository.save(mapperService.mapperDtoToDomain(requestDto));
        Payment domain = mapperService.mapperDtoToDomain(requestDto);
        Gson gson = new Gson();
        String message = gson.toJson(result);
        when(paymentRepository.save(mapperService.mapperDtoToDomain(requestDto))).thenReturn(result);

        assertEquals(result, domain);
        verify(kafkaProducer, times(1)).send(topic, null, message);
    }

    @Test
    void retrieveCompletedPayments() {
        when(mapperService.mapperListDomainToListDto(Collections.singletonList(model)))
                .thenReturn(Collections.singletonList(paymentResponse));
        List<PaymentResponse> expectResult = mapperService.mapperListDomainToListDto(Collections.singletonList(model));
        when(paymentService.findAllPayment()).thenReturn(Collections.singletonList(paymentResponse));
        List<PaymentResponse> result = paymentService.findAllPayment();
        when(paymentService.findAllPayment()).thenReturn(Collections.singletonList(paymentResponse));

       assertEquals(expectResult, result);
    }
}