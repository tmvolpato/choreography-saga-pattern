package br.com.tmvolpato.ms.adapters.out.repository.mapper;

import br.com.tmvolpato.ms.adapters.out.repository.entity.PaymentEntity;
import br.com.tmvolpato.ms.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentEntity paymentToPaymentEntity(Payment payment);
}
