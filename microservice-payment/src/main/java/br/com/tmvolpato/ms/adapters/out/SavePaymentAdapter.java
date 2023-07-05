package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.repository.PaymentRepository;
import br.com.tmvolpato.ms.adapters.out.repository.mapper.PaymentMapper;
import br.com.tmvolpato.ms.application.core.domain.Payment;
import br.com.tmvolpato.ms.application.ports.out.SavePaymentOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public void execute(final Payment payment) {
        final var paymentEntity = this.paymentMapper.paymentToPaymentEntity(payment);
        this.paymentRepository.save(paymentEntity);
    }
}
