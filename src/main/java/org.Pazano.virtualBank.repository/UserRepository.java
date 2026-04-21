package org.Pazano.virtualBank.repository;

import org.Pazano.virtualBank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
