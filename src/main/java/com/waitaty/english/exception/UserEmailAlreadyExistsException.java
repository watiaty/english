package com.waitaty.english.exception;

public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException(String email) {
        super("User with this email already exists: " + email);
    }
}
