package org.Pazano.VirtualBank.config;

import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.entities.enums.TransactionType;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.AccountRepository;
import org.Pazano.VirtualBank.repository.TransactionRepository;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Pietro", "000.000.000-00", "pietro@gmail.com", "19", "123", null);
        User u2 = new User(null, "Ana", "111.111.111-11", "ana@gmail.com", "20", "456", null);
        userRepository.saveAll(Arrays.asList(u1, u2));

        System.out.println(u1.toString());
        System.out.println(u2.toString());

        Account a1 = new Account(null, new BigDecimal(1000), u1);
        Account a2 = new Account(null, new BigDecimal(1000), u2);
        accountRepository.saveAll(Arrays.asList(a1,a2));

//        Transaction t1 = new Transaction(null, Instant.parse("2026-04-21T17:42:37Z"), a1, u2.getName(), u2.getCpf(), TransactionType.PIX, new BigDecimal(500.00));
//        Transaction t2 = new Transaction(null, Instant.parse("2026-04-21T19:52:16Z"), a2, u1.getName(), u1.getCpf(), TransactionType.PIX, new BigDecimal(200.00));

//        transactionRepository.saveAll(Arrays.asList(t1, t2));

    }
}
