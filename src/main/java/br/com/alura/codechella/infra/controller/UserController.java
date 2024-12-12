package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.UserCreate;
import br.com.alura.codechella.domain.entities.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserCreate createUser;

    public UserController(UserCreate createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        User user = createUser.createUser(
                new User(
                        dto.cpf(),
                        dto.name(),
                        dto.birth(),
                        dto.email()
                )
        );

        return new UserDto(
                user.getCpf(),
                user.getName(),
                user.getBirth(),
                user.getEmail()
        );
    }
}
