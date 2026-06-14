package org.Pazano.VirtualBank.service;

import jakarta.persistence.EntityNotFoundException;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.Pazano.VirtualBank.service.exceptions.DataBaseException;
import org.Pazano.VirtualBank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public User update(Long id, User user) {

        try {
            User selected = userRepository.getReferenceById(id);
            updateData(selected, user);
            return userRepository.save(selected);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            userRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    private void updateData(User selectedUser, User newUser) {
        selectedUser.setName(newUser.getName());
        selectedUser.setEmail(newUser.getEmail());
        selectedUser.setAge(newUser.getAge());
    }

}
