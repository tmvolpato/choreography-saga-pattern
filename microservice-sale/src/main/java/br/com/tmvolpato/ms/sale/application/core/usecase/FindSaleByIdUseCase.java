package br.com.tmvolpato.ms.sale.application.core.usecase;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.port.in.FindSaleByIdInputPort;
import br.com.tmvolpato.ms.sale.application.port.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(final FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale execute(final Long id) {
        return this.findSaleByIdOutputPort.execute(id)
                .orElseThrow(() -> new IllegalArgumentException("Sale not found."));
    }
}
