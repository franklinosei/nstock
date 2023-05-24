/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String query = "SELECT id, email, password FROM authentication WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
//  Change this to use the technician model
                String authEmail = rs.getString("email");
                int id = rs.getInt("genre_id");
                String authPassword = rs.getString("password");
                foundData = new AuthenticationModel();

                foundData.setEmail(authEmail);
                foundData.setPassword(authPassword);
                foundData.setId(id);
            }

            stmt.close();
            rs.close();

            return foundData;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
