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
import java.util.ArrayList;
import models.TechnicianModel;

/**
 *
 * @author iamdveloper
 */
public class TechnicianDAO {

    private Connection conn = null;

    public TechnicianDAO(Connection conn) {

        this.conn = conn;
    }
    
    
//    TODO
    public int insertTechnician(TechnicianModel technician) throws Exception {

        try {
            // Insert query
            String query = "INSERT INTO items (genre_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, technician.getEmail());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
//TODO
    public int updateTechnician(TechnicianModel technician) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE genres SET genre_name = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, technician.getLastName());
            stmt.setInt(2, technician.getLabID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
//TODO
    
    public int deleteItem(TechnicianModel technician) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE items SET deleted = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
//            stmt.setBoolean(1, lab.getDeleted());
            stmt.setInt(2, technician.getLabID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    
//    TODO
    public ArrayList<TechnicianModel> getAllTechnicians() throws Exception {

        try {
            ArrayList<TechnicianModel> techniciansList = new ArrayList<>();
            // Make query
            String query = "SELECT genre_id, genre_name FROM genres";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("genre_name");
                int id = rs.getInt("genre_id");

                // TODO: Update the models to access attributes via constructor
                TechnicianModel lab = new TechnicianModel();
                techniciansList.add(lab);
            }
            stmt.close();
            rs.close();
            return techniciansList;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
}
