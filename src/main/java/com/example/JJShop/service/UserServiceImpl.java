package com.example.JJShop.service;

import com.example.JJShop.exceptions.AlreadyExistsException;
import com.example.JJShop.exceptions.NotFoundException;
import com.example.JJShop.model.User;
import com.example.JJShop.model.enums.ErrorMessages;
import com.example.JJShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if (userFindByEmail.isPresent()){
            throw new AlreadyExistsException(ErrorMessages.USER_EMAIL_EXISTS.getMessage());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userUpdated, Long id) {

        Optional<User> userBd = userRepository.findById(id);
        if (userBd.isEmpty()){
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        Optional<User> userFindByEmail = userRepository.findByEmailAndIdNot(userUpdated.getEmail(), id);
        if (userFindByEmail.isPresent()){
            throw new AlreadyExistsException(ErrorMessages.USER_EMAIL_EXISTS.getMessage());
        }
        userBd.get().setFullName(userUpdated.getFullName());
        userBd.get().setPhoneNumber(userUpdated.getPhoneNumber());
        userBd.get().setEmail(userUpdated.getEmail());
        return userRepository.save(userBd.get());
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        return user.get();
    }

    @Override
    public List<User> findAllUsers() {

        return (List<User>) userRepository.findAll();
    }
}
