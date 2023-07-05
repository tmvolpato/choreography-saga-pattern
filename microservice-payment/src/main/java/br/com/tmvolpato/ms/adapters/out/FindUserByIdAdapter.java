package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.repository.UserRepository;
import br.com.tmvolpato.ms.adapters.out.repository.mapper.UserMapper;
import br.com.tmvolpato.ms.application.core.domain.User;
import br.com.tmvolpato.ms.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> execute(final Long id) {
        final var userEntity = userRepository.findById(id);
        return userEntity.map(userMapper::userEntityToUser);
    }
}
