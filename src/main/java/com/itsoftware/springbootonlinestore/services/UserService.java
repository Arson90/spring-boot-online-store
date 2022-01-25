package com.itsoftware.springbootonlinestore.services;

import com.itsoftware.springbootonlinestore.beans.Cart;
import com.itsoftware.springbootonlinestore.beans.Role;
import com.itsoftware.springbootonlinestore.beans.User;
import com.itsoftware.springbootonlinestore.dto.UserDTO;
import com.itsoftware.springbootonlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long userId) {
       return userRepository.findById(userId)
               .orElseThrow();
    }

    public long saveUser(UserDTO userDTO) {
        String username = userDTO.getFirstName() + "." + userDTO.getLastName() + "@user.com";
        String password = userDTO.getPassword();
        User user = new User(username, password, userDTO.getFirstName(), userDTO.getLastName(), Role.ROLE_CUSTOMER, new Cart());
        return userRepository.save(user).getId();
    }

    public void changeUserPassword(long userId, UserDTO userDTO) {
        userRepository.findById(userId)
                .map(user -> {
                    user.setPassword(userDTO.getPassword());
                    return userRepository.save(user);
                });
    }

    public void deleteUser(long userId) {
        if (userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }
    }
}
