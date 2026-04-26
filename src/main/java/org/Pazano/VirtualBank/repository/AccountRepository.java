package org.Pazano.VirtualBank.repository;

import org.Pazano.VirtualBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
