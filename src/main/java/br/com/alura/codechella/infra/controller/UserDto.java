package br.com.alura.codechella.infra.controller;

import java.time.LocalDate;

public record UserDto(
        String cpf,
        String name,
        LocalDate birth,
        String email
) {
}