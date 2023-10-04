package br.itau.payment.service;

import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.dto.PaymentResponse;
import br.itau.payment.producer.KafkaProducer;
import br.itau.payment.repository.PaymentRepository;
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

    public void createPay(PaymentRequest pay){
        paymentRepository.save(mapperService.mapperDtoToDomain(pay));
        kafkaProducer.send("payment", "key", pay.toString());
    }

    public List<PaymentResponse> findAllPayment(){
       return mapperService.mapperListDomainToListDto(paymentRepository.findAll());
    }


}