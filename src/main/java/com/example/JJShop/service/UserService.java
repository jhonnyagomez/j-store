package com.example.JJShop.service;


import com.example.JJShop.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User userUpdated, Long id);
    User getUserById(Long id);
    List<User> findAllUsers();
}
