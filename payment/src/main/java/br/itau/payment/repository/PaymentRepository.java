package br.itau.payment.repository;

import br.itau.payment.domain.PaymentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDomain, Long> {
}
