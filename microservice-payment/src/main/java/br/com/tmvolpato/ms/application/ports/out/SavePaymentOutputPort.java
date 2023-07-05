package br.com.tmvolpato.ms.application.ports.out;

import br.com.tmvolpato.ms.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void execute(Payment payment);
}
