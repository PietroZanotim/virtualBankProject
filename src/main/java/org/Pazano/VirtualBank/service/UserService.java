package org.Pazano.VirtualBank.service;

import jakarta.persistence.EntityNotFoundException;
import org.Pazano.VirtualBank.dto.UserRequestDTO;
import org.Pazano.VirtualBank.dto.UserResponseDTO;
import org.Pazano.VirtualBank.entities.User;
import org.Pazano.VirtualBank.repository.UserRepository;
import org.Pazano.VirtualBank.service.exceptions.DataBaseException;
import org.Pazano.VirtualBank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        List<User> list = userRepository.findAll();
        if(list.isEmpty()) throw new DataBaseException("Null");
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for(User u : list) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(
                    u.getId(),
                    u.getName(),
                    u.getCpf(),
                    u.getEmail(),
                    u.getAge()
            );
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    public UserResponseDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        if(obj.isEmpty()) throw new ResourceNotFoundException(id);
        User user = obj.get();

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getAge()
        );
        return userResponseDTO;
    }

    public UserResponseDTO insert(UserRequestDTO user){
        User userData = new User(null, user.getName(),user.getCpf(), user.getEmail(), user.getAge(), user.getPassword(),null);
        userRepository.save(userData);

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                userData.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getAge()
        );
        return userResponseDTO;
    }

    public UserResponseDTO update(Long id, UserRequestDTO user) {

        try {
            User selected = userRepository.getReferenceById(id);
            updateData(selected, user);
            userRepository.save(selected);

            return new UserResponseDTO(
                    id,
                    selected.getName(),
                    selected.getEmail(),
                    selected.getEmail(),
                    selected.getAge()
            );

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

    private void updateData(User selectedUser, UserRequestDTO newUser) {
        selectedUser.setName(newUser.getName());
        selectedUser.setEmail(newUser.getEmail());
        selectedUser.setAge(newUser.getAge());
        selectedUser.setPassword(newUser.getPassword());
    }

}
