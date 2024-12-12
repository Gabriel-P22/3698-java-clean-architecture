package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getCpf(),
                user.getName(),
                user.getBirth(),
                user.getEmail()
        );
    }

    public User toDomain(UserEntity entity) {
        return new User(
                entity.getCpf(),
                entity.getName(),
                entity.getBirth(),
                entity.getEmail());
    }

}
