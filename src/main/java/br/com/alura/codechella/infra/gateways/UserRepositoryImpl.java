package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.UserRepositoryJpa;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa repository;

    private final UserEntityMapper mapper;

    public UserRepositoryImpl(UserRepositoryJpa repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(user)
                )
        );
    }

    @Override
    public List<User> getUserList() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
