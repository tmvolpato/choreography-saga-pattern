package br.com.tmvolpato.ms.application.ports.out;

import br.com.tmvolpato.ms.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void execute(Inventory inventory);
}
