package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.GetUserList;
import br.com.alura.codechella.domain.entities.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;

    private final GetUserList getUserList;

    public UserController(CreateUser createUser, GetUserList getUserList) {
        this.createUser = createUser;
        this.getUserList = getUserList;
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

    @GetMapping
    public List<UserDto> getUserList() {
        return getUserList
                .getUserList()
                .stream()
                .map(user -> new UserDto(
                        user.getCpf(),
                        user.getName(),
                        user.getBirth(),
                        user.getEmail()))
                .toList();
    }
}
