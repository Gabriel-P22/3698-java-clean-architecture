package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.address.Address;

import java.time.LocalDate;

public class UserFactory {
    private User user;

    public User withNameCpfAndAge(String name, String cpf, LocalDate birth) {
        this.user = new User(cpf, name, birth, null);
        return this.user;
    }

    public User withAddress(String zipCode, String number, String complement) {
        this.user.setAddress(new Address(
                zipCode, number, complement
        ));

        return this.user;
    }

}
