package org.Pazano.VirtualBank.service;

import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User save(User user){
        return userRepository.save(user);
    }

}
