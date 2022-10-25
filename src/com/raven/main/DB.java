/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;
import java.sql.Connection;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bonbo
 */
public class DB {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "sample_library_system";
    private static Integer portNumber = 3306;
    private static String pass = "@Lacorte2001"; // no password
    
    public static Connection getConnection(){
        Connection connection = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(pass);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portNumber);
        
        try {
            connection = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }


}
