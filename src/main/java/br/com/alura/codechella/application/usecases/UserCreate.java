package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

public class UserCreate {

    private final UserRepository repository;

    public UserCreate(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.create(user);
    }

}
