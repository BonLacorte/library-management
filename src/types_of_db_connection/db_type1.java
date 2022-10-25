/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package types_of_db_connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.raven.main.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/** 
 * Steps on setting-up Database
 * 1 - download mysql-connector-java.jar file
 * 2 - right click library folder and select add .jar file
 * 3 - select the extracted and downloaded mysql-connector-java.jar file
 * 4 - open xampp control panel and start apache and mysql
 * 5 - open http://localhost/phpmyadmin/
 * create a database class here at netbeans
 * 
 */


/**
 *
 * @author bonbo
 */
public class db_type1 {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "sample_library_system";
    private static Integer portNumber = 3306;
    private static String pass = ""; // no password
    
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
