package org.Pazano.VirtualBank.dto;

public class AccountRequestDTO {

    private UserRequestDTO userRequestDTO;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(UserRequestDTO userRequestDTO) {
        this.userRequestDTO = userRequestDTO;
    }

    public UserRequestDTO getUserRequestDTO() {
        return userRequestDTO;
    }

    public void setUserRequestDTO(UserRequestDTO userRequestDTO) {
        this.userRequestDTO = userRequestDTO;
    }
}
