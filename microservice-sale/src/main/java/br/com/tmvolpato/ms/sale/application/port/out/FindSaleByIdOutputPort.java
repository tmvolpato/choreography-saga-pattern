package br.com.tmvolpato.ms.sale.application.port.out;

import br.com.tmvolpato.ms.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> execute(Long id);
}
