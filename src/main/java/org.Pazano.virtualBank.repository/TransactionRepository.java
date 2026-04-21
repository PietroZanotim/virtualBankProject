package org.Pazano.virtualBank.repository;

import org.Pazano.virtualBank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
