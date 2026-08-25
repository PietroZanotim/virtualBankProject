package org.Pazano.VirtualBank.dto;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String age;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name,String cpf, String email, String age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
