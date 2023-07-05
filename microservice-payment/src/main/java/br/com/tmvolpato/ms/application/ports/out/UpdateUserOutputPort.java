package br.com.tmvolpato.ms.application.ports.out;

import br.com.tmvolpato.ms.application.core.domain.User;

public interface UpdateUserOutputPort {

    void execute(User user);
}
