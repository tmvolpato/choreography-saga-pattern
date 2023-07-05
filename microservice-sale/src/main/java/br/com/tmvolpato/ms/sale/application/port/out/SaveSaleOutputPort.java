package br.com.tmvolpato.ms.sale.application.port.out;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale execute(Sale sale);
}
