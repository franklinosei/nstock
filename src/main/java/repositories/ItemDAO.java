package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ItemTypeModel;
import models.ItemsModel;
import models.SpecificationModel;
import utils.Utils;

public class ItemDAO {

    private Connection conn = null;

    public ItemDAO(Connection conn) {
        this.conn = conn;
    }

    public int insertItem(ItemsModel item) throws Exception {
        try {
            String query = "INSERT INTO items (name, description, faulty, typeID, photo, serialNumber, labID, managerID,  createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setBoolean(3, item.isFaulty());
            stmt.setInt(4, item.getTypeID());
            stmt.setString(5, item.getPhoto());
            stmt.setString(6, item.getSerialNumber());
            stmt.setInt(7, item.getLabID());
            stmt.setInt(8, item.getManagerID());
//            stmt.setInt(9, item.getSpecID());

            String currentTime = Utils.getCurrentDateTime();

            stmt.setString(9, currentTime);
            stmt.setString(10, currentTime);

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

    public ItemsModel getItemById(int itemId) throws Exception {
        try {
            String query = "SELECT * FROM items WHERE itemID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, itemId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int itemID = rs.getInt("itemID");
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean faulty = rs.getBoolean("faulty");
                int typeID = rs.getInt("typeID");
                String photo = rs.getString("photo");
                String serialNumber = rs.getString("serialNumber");
                int labID = rs.getInt("labID");
                int managerID = rs.getInt("managerID");
                int specID = rs.getInt("specID");
                boolean deleted = rs.getBoolean("deleted");

                ItemsModel item = new ItemsModel(itemID, photo, name, description, faulty, typeID, serialNumber, labID, managerID, specID, deleted);
                return item;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

        return null; // Item not found
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
                String photo = rs.getString("photo");

                ItemsModel item = new ItemsModel(itemID, photo, name, description, faulty, typeID, serialNumber, labID, managerID, specID, false);

                itemsList.add(item);
            }

            stmt.close();
            rs.close();
            return itemsList;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<ItemsModel> getAllItemsPerLabID(int id) throws Exception {
        try {
            ArrayList<ItemsModel> itemsList = new ArrayList<>();
            String query = "SELECT * FROM items WHERE deleted = 0 AND labID= ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

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
                String photo = rs.getString("photo");

                ItemsModel item = new ItemsModel(itemID, photo, name, description, faulty, typeID, serialNumber, labID, managerID, specID, false);

                itemsList.add(item);
            }

            stmt.close();
            rs.close();
            return itemsList;
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
                int ramSize = rs.getInt("ramSize");
                int storageSize = rs.getInt("storageSize");
                int screenSize = rs.getInt("screenSize");
                // ... Retrieve other specification attributes from the result set as needed

                SpecificationModel specification = new SpecificationModel(specID, ramSize, storageSize, screenSize);
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

    public List<ItemTypeModel> getAllItemTypes() throws Exception {
        try {
            List<ItemTypeModel> typesList = new ArrayList<>();
            String query = "SELECT * FROM item_types";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int typeID = rs.getInt("typeID");
                String typeName = rs.getString("typeName");

                ItemTypeModel itemTypeModel = new ItemTypeModel(typeID, typeName);
                // ... Set other attributes of the specification object as needed

                typesList.add(itemTypeModel);
            }

            stmt.close();
            rs.close();

            return typesList;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

}
