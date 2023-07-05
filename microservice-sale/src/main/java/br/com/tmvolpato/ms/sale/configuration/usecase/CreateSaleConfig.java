package br.com.tmvolpato.ms.sale.configuration.usecase;

import br.com.tmvolpato.ms.sale.adapters.SaveSaleAdapter;
import br.com.tmvolpato.ms.sale.adapters.SendCreatedSaleAdapter;
import br.com.tmvolpato.ms.sale.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {
    @Bean
    public CreateSaleUseCase createSaleUseCase(SaveSaleAdapter saveSaleAdapter, SendCreatedSaleAdapter sendCreatedSaleAdapter) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
