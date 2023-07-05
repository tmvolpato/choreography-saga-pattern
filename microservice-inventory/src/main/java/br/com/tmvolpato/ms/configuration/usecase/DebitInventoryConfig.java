package br.com.tmvolpato.ms.configuration.usecase;

import br.com.tmvolpato.ms.adapters.out.SendDebitInventoryAdapter;
import br.com.tmvolpato.ms.adapters.out.SendFailedInventoryAdapter;
import br.com.tmvolpato.ms.adapters.out.UpdateInventoryAdapter;
import br.com.tmvolpato.ms.application.core.usecase.DebitInventoryUseCase;
import br.com.tmvolpato.ms.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(final FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
                                                       final UpdateInventoryAdapter updateInventoryAdapter,
                                                       final SendDebitInventoryAdapter sendUpdateInventoryAdapter,
                                                       final SendFailedInventoryAdapter sendFailedInventoryAdapter) {

        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter,
                sendUpdateInventoryAdapter, sendFailedInventoryAdapter);
    }
}
