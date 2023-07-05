package br.com.tmvolpato.ms.sale.adapters.in.resource.mapper;

import br.com.tmvolpato.ms.sale.adapters.in.resource.request.SaleRequest;
import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {
    Sale saleRequestToSale(SaleRequest saleRequest);
}
