package br.com.tmvolpato.ms.configuration.usecase;

import br.com.tmvolpato.ms.adapters.out.SavePaymentAdapter;
import br.com.tmvolpato.ms.adapters.out.SendValidatedPaymentAdapter;
import br.com.tmvolpato.ms.adapters.out.UpdateUserAdapter;
import br.com.tmvolpato.ms.application.core.usecase.FindUserByIdUseCase;
import br.com.tmvolpato.ms.application.core.usecase.SalePaymentUseCase;
import br.com.tmvolpato.ms.application.ports.out.SendFailedPaymentOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(final FindUserByIdUseCase findUserByIdUseCase,
                                                 final UpdateUserAdapter updateUserAdapter,
                                                 final SavePaymentAdapter savePaymentAdapter,
                                                 final SendValidatedPaymentAdapter sendValidatedPaymentAdapter,
                                                 final SendFailedPaymentOutputPort sendFailedPaymentOutputPort) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter,
                sendValidatedPaymentAdapter, sendFailedPaymentOutputPort);
    }
}
