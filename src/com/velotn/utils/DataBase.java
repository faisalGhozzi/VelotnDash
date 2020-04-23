package com.velotn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    String url ="jdbc:mysql://127.0.0.1/velotn?useTimezone=true&serverTimezone=UTC";
    String login = "root";
    String pwd = "";
    public static com.velotn.utils.DataBase db;
    public Connection con;
    private DataBase() {
        try {
            con=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection  getConnection()
    {
        return con;
    }
    public static com.velotn.utils.DataBase getInstance()
    {if(db==null)
        db=new com.velotn.utils.DataBase();
        return db;
    }
}
