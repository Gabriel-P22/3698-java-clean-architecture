package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public class GetUserList {
    private final UserRepository repository;

    public GetUserList(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUserList() {
        return repository.getUserList();
    }
}
