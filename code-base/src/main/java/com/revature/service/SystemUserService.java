package com.revature.service;

import com.revature.model.SystemUser;
import com.revature.repository.SystemUserRepository;

public class SystemUserService {
    private SystemUserRepository systemUserRepository;

    public SystemUserService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    /**
     * Registers a SystemUser.
     *
     * @param user the SystemUser to register
     * @return true if the registration is successful, false otherwise
     */
    public boolean register(SystemUser user) {
        return systemUserRepository.register(user);
    }

    /**
     * Queries the database for a user with the specified username.
     * 
     * @param username The username of the user to be logged in.
     * @param password The password of the user to be logged in.
     * @return The user data if the user is found, or null if they are not.
     */
    public SystemUser login(String username, String password) {
        return systemUserRepository.login(username, password);
    }


}
