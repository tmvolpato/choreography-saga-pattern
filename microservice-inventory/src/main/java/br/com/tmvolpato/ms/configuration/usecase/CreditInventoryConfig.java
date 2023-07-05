package br.com.tmvolpato.ms.configuration.usecase;

import br.com.tmvolpato.ms.adapters.out.SendCreditInventoryAdapter;
import br.com.tmvolpato.ms.application.core.usecase.CreditInventoryUseCase;
import br.com.tmvolpato.ms.application.core.usecase.FindInventoryByProductIdUseCase;
import br.com.tmvolpato.ms.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(final FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
                                                         final UpdateInventoryOutputPort updateInventoryOutputPort,
                                                         final SendCreditInventoryAdapter sendCreditInventoryAdapter) {

        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryOutputPort, sendCreditInventoryAdapter);
    }

}
