package br.com.tmvolpato.ms.sale.application.port.in;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void execute(final Sale sale);
}
