package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.repository.InventoryRepository;
import br.com.tmvolpato.ms.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.tmvolpato.ms.application.core.domain.Inventory;
import br.com.tmvolpato.ms.application.ports.out.UpdateInventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void execute(final Inventory inventory) {
        final var inventoryEntity = this.inventoryEntityMapper.inventoryToInventoryEntity(inventory);
        this.inventoryRepository.saveAndFlush(inventoryEntity);
    }
}
