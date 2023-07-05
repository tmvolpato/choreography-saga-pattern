package br.com.tmvolpato.ms.sale.configuration.usecase;

import br.com.tmvolpato.ms.sale.adapters.FindSaleByIdAdapter;
import br.com.tmvolpato.ms.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(final FindSaleByIdAdapter findSaleByIdAdapter) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
