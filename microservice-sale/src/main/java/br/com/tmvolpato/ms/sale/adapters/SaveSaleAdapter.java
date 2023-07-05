package br.com.tmvolpato.ms.sale.adapters;

import br.com.tmvolpato.ms.sale.adapters.out.repository.SaleRepository;
import br.com.tmvolpato.ms.sale.adapters.out.repository.mapper.SaleMapper;
import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.port.out.SaveSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Sale execute(final Sale sale) {
        final var saleEntity = this.saleMapper.saleToSaleEntity(sale);
        final var saleSaved = this.saleRepository.save(saleEntity);

        return this.saleMapper.saleEntityToSale(saleSaved);
    }
}
