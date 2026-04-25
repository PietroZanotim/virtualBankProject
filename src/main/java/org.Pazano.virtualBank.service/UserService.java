package org.Pazano.virtualBank.service;

import org.Pazano.virtualBank.entities.User;
import org.Pazano.virtualBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User save(User user){
        return userRepository.save(user);
    }

}
