/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velotn.service;

import com.velotn.entity.User;
import com.velotn.utils.DataBase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farah GABSI
 */
public class UserService {

    private Connection con = DataBase.getInstance().getConnection();
    ;
    private Statement ste;

    public UserService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserById(int id) {
        User u = null;
        try {
            String req = "select * from fos_user where id=?";

            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"));
                u.setId(rs.getInt("id"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void modifierUser(User u) {
        try {
            String req = "update fos_user set username=? , password=? , email=? where id=? ";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setString(1, u.getUsername());
            pre.setString(2, u.getPassword());
            pre.setString(3, u.getEmail());

            //pre.setInt(15, u.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByuserName(String username) {
        try {
            String req = "select * from fos_user where username=?";
            User u = null;
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*public void modifierUserPhoto(User u) {
        try {
            String req = "update fos_user set image=?,nom=?,prenom=? where id=? ";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setString(1, u.getImage());
            pre.setString(2, u.getNom());
            pre.setString(3, u.getPrenom());

            pre.setInt(4, u.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void supprimerUser (int id) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from fos_user where id=?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(com.velotn.service.UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
