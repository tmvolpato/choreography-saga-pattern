package br.com.tmvolpato.ms.sale.configuration.usecase;

import br.com.tmvolpato.ms.sale.adapters.SaveSaleAdapter;
import br.com.tmvolpato.ms.sale.application.core.usecase.FinalizeSaleUseCase;
import br.com.tmvolpato.ms.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(final FindSaleByIdUseCase findSaleByIdUseCase,
                                                   final SaveSaleAdapter saveSaleAdapter) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
