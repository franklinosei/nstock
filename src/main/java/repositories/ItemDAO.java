package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ItemsModel;
import models.LabsModel;
import models.SpecificationModel;
import models.TechnicianModel;
import utils.Utils;

public class ItemDAO {

    private Connection conn = null;

    public ItemDAO(Connection conn) {
        this.conn = conn;
    }

    public int insertItem(ItemsModel item) throws Exception {
        try {
            String query = "INSERT INTO items (name, description, faulty, typeID, photo, serialNumber, labID, managerID, specID, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setBoolean(3, item.isFaulty());
            stmt.setInt(4, item.getTypeID());
            stmt.setString(5, item.getPhoto());
            stmt.setString(6, item.getSerialNumber());
            stmt.setInt(7, item.getLabID());
            stmt.setInt(8, item.getManagerID());
            stmt.setInt(9, item.getSpecID());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(10, currentTime);
            stmt.setString(11, currentTime);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int updateItem(ItemsModel item) throws Exception {
        try {
            String updateQuery = "UPDATE items SET name = ?, description = ?, faulty = ?, photo = ? WHERE itemID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setBoolean(3, item.isFaulty());
            stmt.setString(4, item.getPhoto());
            stmt.setInt(5, item.getItemID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int deleteItem(ItemsModel item) throws Exception {
        try {
            String updateQuery = "UPDATE items SET deleted = ? WHERE itemID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setBoolean(1, item.isDeleted());
            stmt.setInt(2, item.getItemID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<ItemsModel> getAllItems() throws Exception {
        try {
            ArrayList<ItemsModel> itemsList = new ArrayList<>();
            String query = "SELECT * FROM items WHERE deleted = 0";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean faulty = rs.getBoolean("faulty");
                int typeID = rs.getInt("typeID");
                String serialNumber = rs.getString("serialNumber");
                int labID = rs.getInt("labID");
                int managerID = rs.getInt("managerID");
                int specID = rs.getInt("specID");
                String createdAt = rs.getString("createdAt");
                String updatedAt = rs.getString("updatedAt");

                ItemsModel item = new ItemsModel(itemID, name, description, faulty, typeID, serialNumber, labID, managerID, specID, false);

                itemsList.add(item);
            }

            stmt.close();
            rs.close();
            return itemsList;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<TechnicianModel> getAllTechnician() throws Exception {
    try {
        List<TechnicianModel> technicianList = new ArrayList<>();
        String query = "SELECT * FROM technicians";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            // Retrieve the technician data from the result set and create a TechnicianModel object
            int technicianID = rs.getInt("technicianID");
            String technicianName = rs.getString("technicianName");
            // ... Retrieve other technician attributes from the result set as needed

            TechnicianModel technician = new TechnicianModel(technicianID, technicianName);
            // ... Set other attributes of the technician object as needed

            technicianList.add(technician);
        }

        stmt.close();
        rs.close();
        return technicianList;
    } catch (SQLException e) {
        throw new Exception(e.getMessage());
    }
}

public List<SpecificationModel> getAllSpecification() throws Exception {
    try {
        List<SpecificationModel> specList = new ArrayList<>();
        String query = "SELECT * FROM specifications";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            // Retrieve the specification data from the result set and create a SpecificationModel object
            int specID = rs.getInt("specID");
            String specName = rs.getString("specName");
            // ... Retrieve other specification attributes from the result set as needed

            SpecificationModel specification = new SpecificationModel(specID, specName);
            // ... Set other attributes of the specification object as needed

            specList.add(specification);
        }

        stmt.close();
        rs.close();
        return specList;
    } catch (SQLException e) {
        throw new Exception(e.getMessage());
    }
}

public List<LabsModel> getAllLabs() throws Exception {
    try {
        List<LabsModel> labList = new ArrayList<>();
        String query = "SELECT * FROM labs";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            // Retrieve the lab data from the result set and create a LabsModel object
            int labID = rs.getInt("labID");
            String labName = rs.getString("labName");
            // ... Retrieve other lab attributes from the result set as needed

            LabsModel lab = new LabsModel(labID, labName);
            // ... Set other attributes of the lab object as needed

            labList.add(lab);
        }

        stmt.close();
        rs.close();
        return labList;
    } catch (SQLException e) {
        throw new Exception(e.getMessage());
    }
}
}