package org.Pazano.VirtualBank.dto;

import java.math.BigDecimal;

public class AccountResponseDTO {

    private Long accountNumber;
    private BigDecimal balance;
    private UserResponseDTO userResponseDTO;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(Long accountNumber, BigDecimal balance, UserResponseDTO userResponseDTO) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userResponseDTO = userResponseDTO;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public void setUserResponseDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }
}
