package br.com.tmvolpato.ms.configuration.usecase;

import br.com.tmvolpato.ms.adapters.out.FindUserByIdAdapter;
import br.com.tmvolpato.ms.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(final FindUserByIdAdapter findUserByIdAdapter) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }
}
