package br.com.tmvolpato.ms.adapters.out.repository.mapper;

import br.com.tmvolpato.ms.adapters.out.repository.entity.UserEntity;
import br.com.tmvolpato.ms.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userEntityToUser(UserEntity userEntity);

    UserEntity userToUserEntity(User user);

}
