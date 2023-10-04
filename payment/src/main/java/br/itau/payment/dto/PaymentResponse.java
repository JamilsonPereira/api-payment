package br.itau.payment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentResponse {

    @JsonProperty("payment-id")
    private Long payment_id;

    @JsonProperty("customer-id")
    private Long customer_id;

    @JsonProperty("debt-id")
    private Long debt_id;

    @JsonProperty("amount-payd")
    private BigDecimal value;

    @JsonProperty("description")
    private String description;

    @JsonProperty("form-payment")
    private String paymentMethod;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datePayment;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getDebt_id() {
        return debt_id;
    }

    public void setDebt_id(Long debt_id) {
        this.debt_id = debt_id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDate datePayment) {
        this.datePayment = datePayment;
    }
}
