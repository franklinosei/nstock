/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.AuthenticationModel;

/**
 *
 * @author iamdveloper
 */
public class AuthDAO {

    private Connection conn = null;

    public AuthDAO(Connection conn) {

        this.conn = conn;
    }

    public int insertNewTechnician(AuthenticationModel auth) throws Exception {

        try {
            // Insert query
            String query = "INSERT INTO authentication (email, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getEmail());
            stmt.setString(2, auth.getPassword());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public AuthenticationModel findUserByEmail(String email) throws Exception {

        AuthenticationModel foundData = null;

        try {
            // Make query
            String query = "SELECT * FROM authentication WHERE email='" + email + "'";
            Statement stmt = conn.createStatement();

//            PreparedStatement stmt = this.conn.prepareStatement(query);
//            stmt.setString(1, email);
//            
//                   System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String authEmail = rs.getString("email");
                int id = rs.getInt("id");
                String authPassword = rs.getString("password");
                
                 System.out.println(authPassword);

                foundData = new AuthenticationModel();

                foundData.setEmail(authEmail);
                foundData.setPassword(authPassword);
                foundData.setId(id);

                stmt.close();
                rs.close();

                return foundData;
            } else {

                stmt.close();
                rs.close();

                return null;
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
