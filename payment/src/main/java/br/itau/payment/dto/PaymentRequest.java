package br.itau.payment.dto;

import java.math.BigDecimal;

public class PaymentRequest {

    private Long customer_id;

    private Long debt_id;

    private BigDecimal value;

    private String description;

    private String paymentMethod;

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
}