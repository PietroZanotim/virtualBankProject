package org.Pazano.VirtualBank.repository;

import org.Pazano.VirtualBank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
