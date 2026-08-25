package org.Pazano.VirtualBank.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "Name is necessary.")
    private String name;
    @NotBlank(message = "Cpf is necessary.")
    private String cpf;
    @NotBlank(message = "Email is necessary.")
    private String email;
    @NotBlank(message = "Age is necessary.")
    private String age;
    @NotBlank(message = "Password is necessary.")
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String cpf, String email, String age, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
