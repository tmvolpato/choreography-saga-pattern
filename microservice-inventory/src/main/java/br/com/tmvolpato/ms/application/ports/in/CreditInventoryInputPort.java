package br.com.tmvolpato.ms.application.ports.in;

import br.com.tmvolpato.ms.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void execute(Sale sale);
}
