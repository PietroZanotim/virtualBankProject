package org.Pazano.virtualBank.repository;

import org.Pazano.virtualBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
