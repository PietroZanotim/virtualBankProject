package org.Pazano.VirtualBank.resource;

import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.service.AccountService;
import org.Pazano.VirtualBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        List<Transaction> list = transactionService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transaction> findById(Long id) {
        Transaction transaction = transactionService.findById(id);
        return ResponseEntity.ok().body(transaction);
    }

}
