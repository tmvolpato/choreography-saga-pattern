package br.com.tmvolpato.ms.adapters.out.repository.mapper;

import br.com.tmvolpato.ms.adapters.out.repository.entity.InventoryEntity;
import br.com.tmvolpato.ms.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory inventoryEntityToInventory(InventoryEntity inventoryEntity);

    InventoryEntity inventoryToInventoryEntity(Inventory inventory);

}
