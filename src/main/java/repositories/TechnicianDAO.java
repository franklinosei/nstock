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
import models.LabsModel;
import models.RoleModel;
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

//    public TechnicianModel fetchTechnicianRole(TechnicianModel technician) throws Exception {
//        try {
//            String query = "SELECT l.labID, l.labName, l.city, l.region, m.managerID, m.firstName, m.lastName, m.gender, m.phone, m.email, m.dob, m.photo, m.roleID, m.labID, r.roleName, r.roleID FROM labs AS l\n"
//                    + "JOIN managers as m ON m.managerID = managerID\n"
//                    + "JOIN roles as r ON m.roleID = r.roleID;";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            // Assuming TechnicianModel has appropriate setters for the fetched values
//            if (rs.next()) {
//                technician.setManagerID(rs.getInt("managerID"));
//                technician.setFirstName(rs.getString("firstName"));
//                technician.setLastName(rs.getString("lastName"));
//                technician.setGender(rs.getString("gender"));
//                technician.setPhone(rs.getString("phone"));
//                technician.setEmail(rs.getString("email"));
//                technician.setAddress(rs.getString("address"));
//                technician.setDob(rs.getDate("dob"));
//                technician.setPhoto(rs.getString("photo"));
//                technician.setRoleID(rs.getInt("roleID"));
//
//                RoleModel fetchedRole = new RoleModel(rs.getInt("roleID"), rs.getString("roleName"));
//                technician.setAssignedRole(fetchedRole);
//
//                LabsModel fetchedLab = new LabsModel(rs.getInt("labID"), rs.getString("labName"), rs.getString("city"), rs.getString("region"));
//                technician.setAssignedLab(fetchedLab);
//
//            }
//
//            // Close the statement and result set
//            stmt.close();
//            rs.close();
//
//        } catch (SQLException e) {
//            throw new Exception("Error fetching technician role", e);
//        }
//
//        return technician;
//    }

    public ArrayList<TechnicianModel> getAllTechnicians() throws Exception {

        try {
            ArrayList<TechnicianModel> techniciansList = new ArrayList<>();
            // Make query
             String query = "SELECT l.labID, l.labName, l.city, l.region, m.address, m.managerID, m.firstName, m.lastName, m.gender, m.phone, m.email, m.dob, m.photo, m.roleID, m.labID, r.roleName, r.roleID FROM managers AS m\n"
                    + "JOIN labs as l ON m.labID = l.labID\n"
                    + "JOIN roles as r ON m.roleID = r.roleID WHERE m.deleted = 0;";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                TechnicianModel technician = new TechnicianModel();

                technician.setManagerID(rs.getInt("managerID"));
                technician.setFirstName(rs.getString("firstName"));
                technician.setLastName(rs.getString("lastName"));
                technician.setGender(rs.getString("gender"));
                technician.setPhone(rs.getString("phone"));
                technician.setEmail(rs.getString("email"));
                technician.setAddress(rs.getString("address"));
                technician.setDob(rs.getDate("dob"));
                technician.setPhoto(rs.getString("photo"));
                technician.setRoleID(rs.getInt("roleID"));

                RoleModel fetchedRole = new RoleModel(rs.getInt("roleID"), rs.getString("roleName"));
                technician.setAssignedRole(fetchedRole);

                LabsModel fetchedLab = new LabsModel(rs.getInt("labID"), rs.getString("labName"), rs.getString("city"), rs.getString("region"));
                technician.setAssignedLab(fetchedLab);

                techniciansList.add(technician);
            }
            stmt.close();
            rs.close();
            return techniciansList;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

    public TechnicianModel getTechnicianByID(int managerID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
