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
import java.util.Date;
import models.TechnicianModel;
import utils.Utils;

/**
 *
 * @author iamdveloper
 */
public class TechnicianDAO {

    private Connection conn = null;

    public TechnicianDAO(Connection conn) {

        this.conn = conn;
    }

    public int insertTechnician(TechnicianModel technician) throws Exception {

        try {
            // Insert query
            String query = "INSERT INTO managers (firstName, lastName, gender, phone, email, address, dob, photo, roleID, labID, createdAt, updatedAt) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, technician.getFirstName());
            stmt.setString(2, technician.getLastName());
            stmt.setString(3, technician.getGender());
            stmt.setString(4, technician.getPhone());
            stmt.setString(5, technician.getEmail());
            stmt.setString(6, technician.getAddress());
            stmt.setDate(7, (java.sql.Date) technician.getDob());
            stmt.setString(8, technician.getPhoto());
            stmt.setInt(9, technician.getRoleID());
            stmt.setInt(10, technician.getLabID());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(11, currentTime);
            stmt.setString(12, currentTime);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public int updateTechnician(TechnicianModel technician) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE managers SET firstName = ?, lastName = ?, gender = ?,phone =?, email = ?, address = ?,dob = ?,photo = ?, updatedAt = ? WHERE managerID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setString(1, technician.getFirstName());
            stmt.setString(2, technician.getLastName());
            stmt.setString(3, technician.getGender());
            stmt.setString(4, technician.getPhone());
            stmt.setString(5, technician.getEmail());
            stmt.setString(6, technician.getAddress());
            stmt.setDate(7, (java.sql.Date) technician.getDob());
            stmt.setString(8, technician.getPhoto());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(9, currentTime);
            stmt.setInt(10, technician.getManagerID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int deleteTechnician(TechnicianModel technician) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE managers SET deleted = 1 WHERE managerID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
//            stmt.setBoolean(1, lab.getDeleted());
            stmt.setInt(2, technician.getManagerID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public TechnicianModel getTechnicianByEmail(String email) throws Exception {
        try {
            String query = "SELECT * FROM managers WHERE email = ? AND deleted = 0";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date dob = rs.getDate("dob");
                String photo = rs.getString("photo");
                int roleID = rs.getInt("roleID");
                int labID = rs.getInt("labID");
                int managerID = rs.getInt("managerID");

                TechnicianModel technician = new TechnicianModel(managerID, firstName, lastName, gender, phone, email, address, dob, photo, roleID, labID);
                stmt.close();
                rs.close();
                return technician;
            }

            stmt.close();
            rs.close();
            return null;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<TechnicianModel> getAllTechnicians() throws Exception {

        try {
            ArrayList<TechnicianModel> techniciansList = new ArrayList<>();
            // Make query
            String query = "SELECT * FROM managers WHERE deleted = 0";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date dob = rs.getDate("dob");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                String labID = rs.getString("labID");
                int managerID = rs.getInt("managerID");

                // TODO: Update the models to access attributes via constructor
                TechnicianModel lab = new TechnicianModel(managerID, firstName, lastName, gender, phone, email, address, dob, photo, managerID, managerID);
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
