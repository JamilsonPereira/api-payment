package br.itau.payment.service;

import br.itau.payment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private MapperService mapperService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);



}