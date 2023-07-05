package br.com.tmvolpato.ms.application.ports.out;

import br.com.tmvolpato.ms.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> execute(Long id);
}
