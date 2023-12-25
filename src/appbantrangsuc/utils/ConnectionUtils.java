/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipvl
 */
public class ConnectionUtils {
    
    private static ConnectionUtils instance;
    
    public static final String DB_NAME = "TrangSuc";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "integratedSecurity=true;"
            + "trustServerCertificate=true"
            ;

    public void setNull() {
        instance = null;
    }
    private final String username = "NgoanNguyen";
    private final String password = "1";
    private Connection connection;
    
    private ConnectionUtils() {
        init();
    }
    
    public static ConnectionUtils getInstance() {
        if (instance == null) {
            instance = new ConnectionUtils();
        }
        return instance;
    }
    
    public void init() {
        connection = getConnection(DB_URL, null, null);
    }
    
    private Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            if (userName == null && password == null) {
                conn = DriverManager.getConnection(dbURL);
            }
            else
                conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disable() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
