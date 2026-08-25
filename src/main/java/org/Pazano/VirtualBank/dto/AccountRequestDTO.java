package org.Pazano.VirtualBank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AccountRequestDTO {

    @NotBlank(message = "cpf must exist")
    private String cpf;
    @NotBlank(message = "password must exist")
    private String password;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
