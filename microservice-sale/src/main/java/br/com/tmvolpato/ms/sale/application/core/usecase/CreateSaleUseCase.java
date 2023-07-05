package br.com.tmvolpato.ms.sale.application.core.usecase;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.sale.application.port.in.CreateSaleInputPort;
import br.com.tmvolpato.ms.sale.application.port.out.SaveSaleOutputPort;
import br.com.tmvolpato.ms.sale.application.port.out.SendCreateSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreateSaleOutputPort sendCreateSaleOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort, SendCreateSaleOutputPort sendCreateSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreateSaleOutputPort = sendCreateSaleOutputPort;
    }

    @Override
    public void execute(final Sale sale) {
        sale.statusInitial();
        final var saleSaved = this.saveSaleOutputPort.execute(sale);
        this.sendCreateSaleOutputPort.execute(saleSaved, SaleEventEnum.CREATED_SALE);
    }
}
