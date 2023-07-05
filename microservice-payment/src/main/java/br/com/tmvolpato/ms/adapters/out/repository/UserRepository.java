package br.com.tmvolpato.ms.adapters.out.repository;

import br.com.tmvolpato.ms.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
