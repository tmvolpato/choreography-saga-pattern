package br.com.tmvolpato.ms.sale.application.core.usecase;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.port.in.CancelSaleInputPort;
import br.com.tmvolpato.ms.sale.application.port.in.FindSaleByIdInputPort;
import br.com.tmvolpato.ms.sale.application.port.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(final FindSaleByIdInputPort findSaleByIdInputPort,
                             final SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void execute(final Sale sale) {
        var saleResponse = this.findSaleByIdInputPort.execute(sale.getId());
        saleResponse.statusCanceled();

        this.saveSaleOutputPort.execute(saleResponse);
    }
}
