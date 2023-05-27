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
import models.ItemsModel;
import utils.Utils;

/**
 *
 * @author iamdveloper
 */
public class ItemDAO {
    
    private Connection conn = null;
    
    public ItemDAO(Connection conn) {
        
        this.conn = conn;
    }
    
    public int insertItem(ItemsModel item) throws Exception {
        
        try {
            // Insert query
            String query = "INSERT INTO items (name, description, faulty, typeID, photo, serialNumber, labID, managerID, specID, createdAt, updatedAt) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setBoolean(3, item.getFaulty());
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
            
            return rowsAffected;
            
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        
    }
    
    public int updateItem(ItemsModel item) throws Exception {
        
        try {
            // Update data
            String updateQuery = "UPDATE items SET name = ?, description = ?, faulty = ?,  photo = ? WHERE itemID = ?;";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setBoolean(3, item.getFaulty());
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
            // Update data
            String updateQuery = "UPDATE items SET deleted = ? WHERE iteMID = ?";
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

//TODO
//    public ItemsModel getItemByID(int id) throws Exception {
//
//        try {
//            // Update data
//            String updateQuery = "SELECT * FROM items WHERE id = ?";
//            PreparedStatement stmt = conn.prepareStatement(updateQuery);
//            stmt.setInt(1, id);
//
//            int rowsAffected = stmt.executeUpdate();
//            stmt.close();
//            
//            return rowsAffected;
//
//        } catch (SQLException e) {
//            throw new Exception(e.getMessage());
//        }
//    }
    
//    public ItemsModel findItemByID(int id) throws Exception {
//
//        ItemsModel foundData = null;
//
//        try {
//            // Make query
//            String query = "SELECT id, email, password FROM authentication WHERE email = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, email);
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
////  Change this to use the technician model
//                String authEmail = rs.getString("email");
//                int id = rs.getInt("genre_id");
//                String authPassword = rs.getString("password");
//                foundData = new ItemsModel();
//
//                foundData.setEmail(authEmail);
//                foundData.setPassword(authPassword);
//                foundData.setId(id);
//            }
//
//            stmt.close();
//            rs.close();
//
//            return foundData;
//
//        } catch (SQLException e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//    
    
    public ArrayList<ItemsModel> getAllItems() throws Exception {
        
        try {
            ArrayList<ItemsModel> itemsList = new ArrayList<>();
            // Make query
            String query = "SELECT * FROM items WHERE deleted = 0";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                
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
                int itemID = rs.getInt("itemID");

                // TODO: Update the models to access attributes via constructor
                ItemsModel item = new ItemsModel(itemID, name, description, faulty, typeID, name, name, serialNumber, labID, managerID, specID, faulty);
                itemsList.add(item);
            }
            
            stmt.close();
            rs.close();
            return itemsList;
            
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        
    }
    
}
