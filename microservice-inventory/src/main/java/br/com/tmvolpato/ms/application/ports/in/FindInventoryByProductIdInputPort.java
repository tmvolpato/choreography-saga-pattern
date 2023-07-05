package br.com.tmvolpato.ms.application.ports.in;

import br.com.tmvolpato.ms.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory execute(Long productId);
}
