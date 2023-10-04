package br.itau.payment.service;

import br.itau.payment.domain.Payment;
import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.dto.PaymentResponse;
import br.itau.payment.producer.KafkaProducer;
import br.itau.payment.repository.PaymentRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private KafkaProducer kafkaProducer;

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public void createPay(PaymentRequest pay) {
        logger.info("Save Payment");
        Payment result = paymentRepository.save(mapperService.mapperDtoToDomain(pay));
        Gson gson = new Gson();
        String message = gson.toJson(result);
        logger.info("Send message for kafka topic");
        kafkaProducer.send("notifications.payment.request", null, message);
    }

    public List<PaymentResponse> findAllPayment() {
        logger.info("Search all Payment");
        return mapperService.mapperListDomainToListDto(paymentRepository.findAll());
    }
}