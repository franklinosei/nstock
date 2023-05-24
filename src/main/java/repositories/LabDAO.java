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
import models.LabsModel;
import utils.Utils;

/**
 *
 * @author iamdveloper
 */
public class LabDAO {

    private Connection conn = null;

    public LabDAO(Connection conn) {

        this.conn = conn;
    }

    public int insertLab(LabsModel lab) throws Exception {

        try {

            // Insert query
            String query = "INSERT INTO labs (labName, city, region, photo, createdAt, updatedAt) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, lab.getLabName());
            stmt.setString(2, lab.getCity());
            stmt.setString(3, lab.getRegion());
            stmt.setString(4, lab.getPhoto());

//            get current time
            String currentTime = Utils.getCurrentDateTime();
            stmt.setString(5, currentTime);
            stmt.setString(6, currentTime);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }


    public int updateLab(LabsModel lab) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE labs SET labName = ?, city = ?, region = ?, photo = ?, updatedAt = ? WHERE labID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, lab.getLabName());
            stmt.setString(2, lab.getCity());
            stmt.setString(3, lab.getRegion());
            stmt.setString(4, lab.getPhoto());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(5, currentTime);
            stmt.setInt(6, lab.getLabID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int deleteLab(LabsModel lab) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE labs SET deleted = ? WHERE labID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setBoolean(1, true);
            stmt.setInt(2, lab.getLabID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }


    public ArrayList<LabsModel> getAllLabs() throws Exception {

        try {
            ArrayList<LabsModel> labsList = new ArrayList<>();
            // Make query
            String query = "SELECT * FROM labs WHERE deleted = 0";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("labName");
                String city = rs.getString("city");
                String region = rs.getString("regioin");
                String photo = rs.getString("photo");
                String createdAt = rs.getString("createdAt");
                String updatedAt = rs.getString("updatedAt");
                int id = rs.getInt("labID");

                // TODO: Update the models to access attributes via constructor
                LabsModel lab = new LabsModel(id, name, city, region, photo);
                labsList.add(lab);
            }
            stmt.close();
            rs.close();
            return labsList;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
}
