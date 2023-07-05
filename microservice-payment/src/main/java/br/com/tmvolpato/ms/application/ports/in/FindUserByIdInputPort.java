package br.com.tmvolpato.ms.application.ports.in;

import br.com.tmvolpato.ms.application.core.domain.User;

public interface FindUserByIdInputPort {

    User execute(Long id);
}
