package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.LabsModel;
import utils.Utils;

public class LabDAO {

    private Connection conn;

    public LabDAO(Connection conn) {
        this.conn = conn;
    }

    public int insertLab(LabsModel lab) throws Exception {
        try {
            String query = "INSERT INTO labs (labName, city, region, photo, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, lab.getLabName());
            stmt.setString(2, lab.getCity());
            stmt.setString(3, lab.getRegion());
            stmt.setString(4, lab.getPhoto());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(5, currentTime);
            stmt.setString(6, currentTime);
            int rowsAffected = stmt.executeUpdate();

            stmt.close();

            return rowsAffected;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int updateLab(LabsModel lab) throws Exception {
        try {
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

    public List<LabsModel> getAllLabs() throws Exception {
        try {
            List<LabsModel> labsList = new ArrayList<>();
            String query = "SELECT * FROM labs";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("labName");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String photo = rs.getString("photo");
                Timestamp createdAt = rs.getTimestamp("createdAt");
                Timestamp updatedAt = rs.getTimestamp("updatedAt");
                int id = rs.getInt("labID");

                LabsModel lab = new LabsModel(id, name, city, region, photo);
                lab.setCreatedAt(createdAt);
                lab.setUpdatedAt(updatedAt);
                labsList.add(lab);

                // Print the retrieved lab
                System.out.println("Lab ID: " + lab.getLabID());
                System.out.println("Lab Name: " + lab.getLabName());
                System.out.println("City: " + lab.getCity());
                System.out.println("Region: " + lab.getRegion());
                System.out.println("Photo: " + lab.getPhoto());
                System.out.println("Created At: " + lab.getCreatedAt());
                System.out.println("Updated At: " + lab.getUpdatedAt());
                System.out.println("----------------------------------");
            }
            stmt.close();
            rs.close();
            return labsList;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public LabsModel getLabByID(int labID) throws Exception {
        try {
            String query = "SELECT * FROM labs WHERE labID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, labID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("labName");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String photo = rs.getString("photo");
                Timestamp createdAt = rs.getTimestamp("createdAt");
                Timestamp updatedAt = rs.getTimestamp("updatedAt");

                LabsModel lab = new LabsModel(labID, name, city, region, photo);
                lab.setCreatedAt(createdAt);
                lab.setUpdatedAt(updatedAt);

                stmt.close();
                rs.close();

                return lab;
            }

            stmt.close();
            rs.close();

            return null;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int deleteLab(int labID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
