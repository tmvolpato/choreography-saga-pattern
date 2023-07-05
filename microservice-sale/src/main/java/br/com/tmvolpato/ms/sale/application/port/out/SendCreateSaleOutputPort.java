package br.com.tmvolpato.ms.sale.application.port.out;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.core.domain.enums.SaleEventEnum;

public interface SendCreateSaleOutputPort {

    void execute(Sale sale, SaleEventEnum saleEventEnum);
}
