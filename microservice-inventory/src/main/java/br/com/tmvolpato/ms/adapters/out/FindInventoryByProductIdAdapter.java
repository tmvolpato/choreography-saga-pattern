package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.repository.InventoryRepository;
import br.com.tmvolpato.ms.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.tmvolpato.ms.application.core.domain.Inventory;
import br.com.tmvolpato.ms.application.ports.out.FindInventoryByProductIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> execute(final Long productId) {
        final var inventoryEntity = this.inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(this.inventoryEntityMapper::inventoryEntityToInventory);
    }
}
