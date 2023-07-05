package br.com.tmvolpato.ms.adapters.out.repository;

import br.com.tmvolpato.ms.adapters.out.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
