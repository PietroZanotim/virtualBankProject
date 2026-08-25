package org.Pazano.VirtualBank.service;

import jakarta.persistence.EntityNotFoundException;
import org.Pazano.VirtualBank.dto.AccountRequestDTO;
import org.Pazano.VirtualBank.dto.AccountResponseDTO;
import org.Pazano.VirtualBank.dto.UserResponseDTO;
import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.AccountRepository;
import org.Pazano.VirtualBank.repository.TransactionRepository;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.Pazano.VirtualBank.service.exceptions.DataBaseException;
import org.Pazano.VirtualBank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AccountResponseDTO> findAll() {
        List<Account> list = accountRepository.findAll();
        if(list.isEmpty()) throw new DataBaseException("Null");
        List<AccountResponseDTO> accountResponseDTOList = new ArrayList<>();

        for(Account a : list) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(
                    a.getUser().getId(),
                    a.getUser().getName(),
                    a.getUser().getCpf(),
                    a.getUser().getEmail(),
                    a.getUser().getAge()
            );

            AccountResponseDTO accountResponseDTO = new AccountResponseDTO(
                    a.getAccountNumber(),
                    a.getBalance(),
                    userResponseDTO
            );

            accountResponseDTOList.add(accountResponseDTO);
        }
        return accountResponseDTOList;
    }

    public AccountResponseDTO findById(Long id) {
        Optional<Account> obj = accountRepository.findById(id);
        if(obj.isEmpty()) throw new ResourceNotFoundException(id);
        Account account = obj.get();

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                account.getUser().getId(),
                account.getUser().getName(),
                account.getUser().getCpf(),
                account.getUser().getEmail(),
                account.getUser().getAge()
        );

        return new AccountResponseDTO(
                account.getAccountNumber(),
                account.getBalance(),
                userResponseDTO
        );
    }

    public AccountResponseDTO insert(AccountRequestDTO account) {

        Optional<User> newUser = userRepository.findByCpf(account.getCpf());
        if (newUser.isEmpty()) throw new DataBaseException("User not found");
        if(!newUser.get().getPassword().equals(account.getPassword())) throw new DataBaseException("Invalid password");

        Account newAccount = new Account(null, BigDecimal.valueOf(0.00), newUser.get());
        newAccount = accountRepository.save(newAccount);

        //Creating DTO;
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                newUser.get().getId(),
                newUser.get().getName(),
                newUser.get().getCpf(),
                newUser.get().getEmail(),
                newUser.get().getAge()
        );

        AccountResponseDTO accountResponseDTO = new AccountResponseDTO(newAccount.getAccountNumber(), newAccount.getBalance(), userResponseDTO);
        return accountResponseDTO;
    }

    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            accountRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

}
