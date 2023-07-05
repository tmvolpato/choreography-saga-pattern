package br.com.tmvolpato.ms.configuration.usecase;

import br.com.tmvolpato.ms.adapters.out.FindInventoryByProductIdAdapter;
import br.com.tmvolpato.ms.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(final FindInventoryByProductIdAdapter findInventoryByProductIdAdapter) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
