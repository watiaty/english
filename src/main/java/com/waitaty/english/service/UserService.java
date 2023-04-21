package com.waitaty.english.service;

import com.waitaty.english.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
