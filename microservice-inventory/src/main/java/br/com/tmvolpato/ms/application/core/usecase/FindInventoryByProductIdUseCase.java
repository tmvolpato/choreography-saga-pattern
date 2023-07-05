package br.com.tmvolpato.ms.application.core.usecase;

import br.com.tmvolpato.ms.application.core.domain.Inventory;
import br.com.tmvolpato.ms.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.tmvolpato.ms.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory execute(final Long productId) {
        return this.findInventoryByProductIdOutputPort.execute(productId)
                .orElseThrow(() -> new RuntimeException("estoque não encontrado para esse produto"));
    }
}
