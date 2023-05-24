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

/**
 *
 * @author iamdveloper
 */
public class ItemDAO {

    private Connection conn = null;

    public ItemDAO(Connection conn) {

        this.conn = conn;
    }

//    TODO
    public int insertItem(ItemsModel item) throws Exception {

        try {
            // Insert query
            String query = "INSERT INTO items (genre_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getName());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }

//    TODO
    public int updateItem(ItemsModel item) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE genres SET genre_name = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getItemID());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

//    TODO
    public int deleteItem(ItemsModel item) throws Exception {

        try {
            // Update data
            String updateQuery = "UPDATE items SET deleted = ? WHERE genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setBoolean(1, item.getDeleted());
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

//    TODO
    public ArrayList<ItemsModel> getAllItems() throws Exception {

        try {
            ArrayList<ItemsModel> itemsList = new ArrayList<>();
            // Make query
            String query = "SELECT genre_id, genre_name FROM genres";
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("genre_name");
                String dewscription = rs.getString("description");
                
                int id = rs.getInt("genre_id");

                // TODO: Update the models to access attributes via constructor
                ItemsModel item = new ItemsModel();
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
