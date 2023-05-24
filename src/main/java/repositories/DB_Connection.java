/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author iamdveloper
 */
public class DB_Connection {
       private static Connection conn = null;

    String password = "123@Moako";
    String username = "root";
    String url = "jdbc:mysql://localhost:3306/nstock?autoReconnect=true&useSSL=false";

//    private Statement stmt;
    public Connection connect() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }

        try {
            if (conn == null || conn.isClosed()) {

                conn = DriverManager.getConnection(url, username, password);
            }
            return conn;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public static void closeConnection() throws Exception {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
