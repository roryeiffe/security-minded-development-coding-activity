package com.revature.repository;

import com.revature.model.SystemUser;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SystemUserRepository {

    private Connection conn;

    /**
     * Registers a new system user.
     *
     * @param user the system user to register
     * @return true if the user is registered successfully, false otherwise
     * @throws SQLException if an error occurs while registering the user
     */
    public boolean register(SystemUser user) {
        // first check if username or email already exist:
        String sql = "SELECT * FROM users WHERE username = ? OR email = ?";
        try {
            conn = ConnectionFactory.getInstance().getConnection();
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        // Otherwise, insert the user:
        String sql2 = "INSERT INTO users (username, password, fname, lname, email, role) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getRole());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Authenticates a user by their username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated user object.
     * @throws RuntimeException if an error occurs while authenticating the user.
     */
    public SystemUser login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String encryptedPassword = "";
                for(int i = 0; i < password.length(); i++) encryptedPassword += "*";;
                return new SystemUser(rs.getInt("id"), rs.getString("username"), encryptedPassword, rs.getString("fname"), rs.getString("lname"), rs.getString("email"), rs.getString("role"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

}
