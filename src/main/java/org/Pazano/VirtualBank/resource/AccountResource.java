package org.Pazano.VirtualBank.resource;

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
    private AccountService AccountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> list = AccountService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Account account = AccountService.findById(id);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping
    public ResponseEntity<Account> insert(@RequestBody Account ac) throws InsufficientBalanceException {
        Account account = AccountService.insert(ac);
        return ResponseEntity.ok().body(ac);
    }

    @DeleteMapping
    public ResponseEntity<Account> delete(@PathVariable Long id) throws InsufficientBalanceException {
        AccountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account acc) throws InsufficientBalanceException{
        AccountService.update(id, acc);
        return ResponseEntity.ok().body(acc);
    }

}
