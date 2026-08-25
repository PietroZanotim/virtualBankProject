package org.Pazano.VirtualBank.resource;

import jakarta.validation.Valid;
import org.Pazano.VirtualBank.dto.TransactionRequestDTO;
import org.Pazano.VirtualBank.dto.TransactionResponseDTO;
import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.entities.Transaction;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.service.AccountService;
import org.Pazano.VirtualBank.service.TransactionService;
import org.Pazano.VirtualBank.service.exceptions.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.InsufficientResourcesException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> findAll() {
        List<TransactionResponseDTO> list = transactionService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionResponseDTO> findById(@PathVariable Long id) {
        TransactionResponseDTO transaction = transactionService.findById(id);
        return ResponseEntity.ok().body(transaction);
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> insert(@Valid @RequestBody TransactionRequestDTO obj) throws InsufficientBalanceException {
        TransactionResponseDTO dtoResponse = transactionService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoResponse.getTransactionId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

}
