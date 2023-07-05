package br.com.tmvolpato.ms.application.ports.out;

import br.com.tmvolpato.ms.application.core.domain.Sale;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;

public interface SendDebitInventoryOutputPort {

    void execute(Sale sale, SaleEventEnum saleEventEnum);
}
