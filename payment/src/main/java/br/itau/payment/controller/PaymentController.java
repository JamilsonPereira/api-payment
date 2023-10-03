package br.itau.payment.controller;

import br.itau.payment.dto.PaymentRequest;
import br.itau.payment.dto.PaymentResponse;
import br.itau.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Api(value = "API REST Payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @ApiOperation(value = "Create payment")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionaArrayPalindromo(@RequestBody PaymentRequest palindromo) {
     ;
    }

    @ApiOperation(value = "Busca uma lista com palindromos")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> buscarPalindromosGerados() {
        return paymentService.buscarPalindromosNaBaseDeDados();
    }
}