package br.com.tmvolpato.ms.application.core.usecase;

import br.com.tmvolpato.ms.application.core.domain.Sale;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.application.ports.in.CreditInventoryInputPort;
import br.com.tmvolpato.ms.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.tmvolpato.ms.application.ports.out.SendCreditInventoryOutputPort;
import br.com.tmvolpato.ms.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendCreditInventoryOutputPort sendCreditInventoryOutputPort;

    public CreditInventoryUseCase(final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  final UpdateInventoryOutputPort updateInventoryOutputPort,
                                  final SendCreditInventoryOutputPort sendCreditInventoryOutputPort) {

        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendCreditInventoryOutputPort = sendCreditInventoryOutputPort;
    }

    @Override
    public void execute(final Sale sale) {
        var inventory = this.findInventoryByProductIdInputPort.execute(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());

        this.updateInventoryOutputPort.execute(inventory);
        this.sendCreditInventoryOutputPort.execute(sale, SaleEventEnum.ROLLBACK_INVENTORY);
    }
}
