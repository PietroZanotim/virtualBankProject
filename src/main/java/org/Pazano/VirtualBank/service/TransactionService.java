package org.Pazano.VirtualBank.service;

import jakarta.transaction.Transactional;
import org.Pazano.VirtualBank.dto.TransactionRequestDTO;
import org.Pazano.VirtualBank.dto.TransactionResponseDTO;
import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.AccountRepository;
import org.Pazano.VirtualBank.repository.TransactionRepository;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.Pazano.VirtualBank.service.exceptions.*;
import org.Pazano.VirtualBank.service.exceptions.IllegalArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        Optional<Transaction> obj = transactionRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public TransactionResponseDTO insert(TransactionRequestDTO transactionRequestDTO) throws InsufficientBalanceException {

        Account senderAccount = accountRepository.findById(transactionRequestDTO.getSenderAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Sender account not found."));

        //Insufficient balance
        if(senderAccount.getBalance().compareTo(transactionRequestDTO.getTotal())<0) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        //Negative value
        if(transactionRequestDTO.getTotal().compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException("Negative value!");
        }
        //Same account sender and receiver
        if(transactionRequestDTO.getReceiverCpf().equals(senderAccount.getUser().getCpf())){
            throw new BusinessRuleException("Invalid receiver account!");
        }

        senderAccount.withdraw(transactionRequestDTO.getTotal()); //withdraw the value;

        User user = userRepository.findByCpf(transactionRequestDTO.getReceiverCpf())
                .orElseThrow(() -> new ResourceNotFoundException("Receiver not found."));

        Account accountReceiver = user.getAccount();
        accountReceiver.deposit(transactionRequestDTO.getTotal());

        Transaction transactionDatabase = new Transaction(null,
                Instant.now(),
                senderAccount,
                accountReceiver.getUser().getName(),
                accountReceiver.getUser().getCpf(),
                transactionRequestDTO.getTransactionType(),
                transactionRequestDTO.getTotal()
        );


        transactionRepository.save(transactionDatabase);

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO(
                transactionDatabase.getId(),
                accountReceiver.getUser().getName(),
                transactionRequestDTO.getTotal(),
                transactionDatabase.getData()
        );

        return transactionResponseDTO;
    }

}
