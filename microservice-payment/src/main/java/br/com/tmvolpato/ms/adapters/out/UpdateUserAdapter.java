package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.repository.UserRepository;
import br.com.tmvolpato.ms.adapters.out.repository.mapper.UserMapper;
import br.com.tmvolpato.ms.application.core.domain.User;
import br.com.tmvolpato.ms.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void execute(final User user) {
        final var userEntity = userMapper.userToUserEntity(user);
        this.userRepository.saveAndFlush(userEntity);
    }

}
