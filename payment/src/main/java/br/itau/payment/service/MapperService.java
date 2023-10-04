package br.itau.payment.service;

import br.itau.payment.domain.Payment;
import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.dto.PaymentResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperService {

    public List<PaymentResponse> mapperListDomainToListDto(List<Payment> domain) {
        List<PaymentResponse> paymentResponses = new ArrayList<>();

        for (Payment payment : domain) {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPayment_id(payment.getPayment_id());
            paymentResponse.setCustomer_id(payment.getCustomerId());
            paymentResponse.setValue(payment.getValue());
            paymentResponse.setPaymentMethod(payment.getPaymentMethod());
            paymentResponse.setDatePayment(payment.getDatePayment());
            paymentResponse.setDescription(payment.getDescription());
            paymentResponses.add(paymentResponse);
        }
        return paymentResponses;
    }

    public Payment mapperDtoToDomain(PaymentRequest request) {
        Payment domain = new Payment();
        domain.setPaymentMethod(request.getPaymentMethod());
        domain.setCustomerId(request.getCustomer_id());
        domain.setDescription(request.getDescription());
        domain.setValue(request.getValue());
        domain.setDebtId(request.getDebt_id());

        return domain;
    }

    public PaymentResponse mapperListDomainToListDto(Payment model) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPayment_id(model.getPayment_id());
        paymentResponse.setPaymentMethod(model.getPaymentMethod());
        paymentResponse.setCustomer_id(model.getCustomerId());
        paymentResponse.setDescription(model.getDescription());
        paymentResponse.setValue(model.getValue());

        return paymentResponse;
    }
}