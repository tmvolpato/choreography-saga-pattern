package br.com.tmvolpato.ms.application.core.usecase;

import br.com.tmvolpato.ms.application.core.domain.User;
import br.com.tmvolpato.ms.application.ports.in.FindUserByIdInputPort;
import br.com.tmvolpato.ms.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(final FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User execute(Long id) {
        return this.findUserByIdOutputPort.execute(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
