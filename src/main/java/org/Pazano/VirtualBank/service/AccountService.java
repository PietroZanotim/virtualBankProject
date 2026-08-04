package org.Pazano.VirtualBank.service;

import jakarta.persistence.EntityNotFoundException;
import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.AccountRepository;
import org.Pazano.VirtualBank.repository.TransactionRepository;
import org.Pazano.VirtualBank.service.exceptions.DataBaseException;
import org.Pazano.VirtualBank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        Optional<Account> obj = accountRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Account insert(Account account) {
        return accountRepository.save(account);
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

    public void update(Long id, Account account) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        Account acc = accountRepository.getReferenceById(id);
        acc.setAccountNumber(account.getAccountNumber());
        acc.setBalance(account.getBalance());

        accountRepository.save(acc);
    }

}
