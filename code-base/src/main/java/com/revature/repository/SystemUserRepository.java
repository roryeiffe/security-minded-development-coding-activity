package com.revature.repository;

import com.revature.model.SystemUser;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SystemUserRepository {

    // TODO: Implement the following method using Gen AI:
    /**
     * Registers a new system user.
     *
     * @param user the system user to register
     * @return true if the user is registered successfully, false otherwise
     */
    public boolean register(SystemUser user) {
        throw new UnsupportedOperationException();
    }

    // TODO: Implement the following method using Gen AI:
    /**
     * Authenticates a user by their username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated user object.
     * @throws UnsupportedOperationException Thrown when the login operation is not supported.
     */
    public SystemUser login(String username, String password) {
        throw new UnsupportedOperationException();
    }

}
