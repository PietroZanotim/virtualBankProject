package org.Pazano.VirtualBank.resource;

import jakarta.validation.Valid;
import org.Pazano.VirtualBank.dto.AccountRequestDTO;
import org.Pazano.VirtualBank.dto.AccountResponseDTO;
import org.Pazano.VirtualBank.entities.Account;
import org.Pazano.VirtualBank.service.AccountService;
import org.Pazano.VirtualBank.service.UserService;
import org.Pazano.VirtualBank.service.exceptions.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> findAll() {
        List<AccountResponseDTO> list = accountService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountResponseDTO> findById(@PathVariable Long id) {
        AccountResponseDTO account = accountService.findById(id);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> insert(@Valid @RequestBody AccountRequestDTO ac) throws InsufficientBalanceException {
        AccountResponseDTO account = accountService.insert(ac);
        return ResponseEntity.ok().body(account);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) throws InsufficientBalanceException {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
