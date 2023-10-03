package br.itau.payment.service;

import br.itau.payment.domain.PaymentDomain;
import br.itau.payment.dto.PaymentResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperService {

    public List<PaymentResponse> converteModelParaDto(List<PaymentDomain> model) {
        List<PaymentResponse> paymentResponses = new ArrayList<>();

        for (PaymentDomain paymentDomain : model) {
            PaymentResponse paymentResponse = new PaymentResponse();

            paymentResponses.add(paymentResponse);
        }
        return paymentResponses;
    }
}
