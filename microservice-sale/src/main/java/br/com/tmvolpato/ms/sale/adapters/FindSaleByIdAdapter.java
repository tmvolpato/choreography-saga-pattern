package br.com.tmvolpato.ms.sale.adapters;

import br.com.tmvolpato.ms.sale.adapters.out.repository.SaleRepository;
import br.com.tmvolpato.ms.sale.adapters.out.repository.mapper.SaleMapper;
import br.com.tmvolpato.ms.sale.application.core.domain.Sale;
import br.com.tmvolpato.ms.sale.application.port.out.FindSaleByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Optional<Sale> execute(final Long id) {
        var saleEntity = this.saleRepository.findById(id);
        return saleEntity.map(this.saleMapper::saleEntityToSale);
    }
}
