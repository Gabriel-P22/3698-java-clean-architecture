package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.GetUserList;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryImpl;
import br.com.alura.codechella.infra.persistence.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository repository) {
        return new CreateUser(repository);
    }

    @Bean
    GetUserList getUserList(UserRepository repository) {
        return new GetUserList(repository);
    }

    @Bean
    UserRepositoryImpl userRepositoryImpl(
            UserRepositoryJpa repository,
            UserEntityMapper mapper
    ) {
        return new UserRepositoryImpl(
                repository,
                mapper
        );
    }

    @Bean
    UserEntityMapper UserEntityMapper() {
        return new UserEntityMapper();
    }

}
