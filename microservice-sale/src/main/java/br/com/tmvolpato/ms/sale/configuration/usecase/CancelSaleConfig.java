package br.com.tmvolpato.ms.sale.configuration.usecase;

import br.com.tmvolpato.ms.sale.adapters.SaveSaleAdapter;
import br.com.tmvolpato.ms.sale.application.core.usecase.CancelSaleUseCase;
import br.com.tmvolpato.ms.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(final FindSaleByIdUseCase findSaleByIdUseCase,
                                               final SaveSaleAdapter saveSaleAdapter) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
