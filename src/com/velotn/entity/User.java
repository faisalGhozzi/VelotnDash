package com.velotn.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khalil
 */
public class User {
    private int id ;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(int id )
    {
        this.id= id ;
    }

    public User(int id_user, String username) {
        this.id = id_user;
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password+"}";
    }

    public static com.velotn.entity.User createUser(ResultSet rs){
        com.velotn.entity.User user = new com.velotn.entity.User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.entity.User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
