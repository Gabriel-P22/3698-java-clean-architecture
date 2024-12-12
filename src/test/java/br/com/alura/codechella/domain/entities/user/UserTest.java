package br.com.alura.codechella.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void throwWithInvalidCpf() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(
                    "111.111.1.-24",
                    "Gabriel",
                    LocalDate.now(),
                    "admin@email.com"
            );
        });
    }

    @Test
    public void createUserWithFactory() {
        UserFactory factory = new UserFactory();
        User user = factory.withNameCpfAndAge(
                "Gabriel",
                "291.664.370-24",
                LocalDate.now()
        );

        assertEquals("Gabriel", user.getName());

    }

    @Test
    public void createUserWithValidAddressWithFactory() {
        UserFactory factory = new UserFactory();
        User user = factory.withNameCpfAndAge(
                "Gabriel",
                "291.664.370-24",
                LocalDate.now()
        );

        user = factory.withAddress("132", "1A", "B3");

        assertEquals("1A", user.getAddress().getNumber());

    }
}
