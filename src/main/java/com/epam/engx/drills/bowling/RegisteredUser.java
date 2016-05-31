package com.epam.engx.drills.bowling;

/**
 * @author Nurmakanov on 21.05.2016.
 */
class RegisteredUser {
    private final String username;
    private final String password;

    RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
