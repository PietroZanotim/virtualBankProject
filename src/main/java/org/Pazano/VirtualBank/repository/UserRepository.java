package org.Pazano.VirtualBank.repository;

import org.Pazano.VirtualBank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
