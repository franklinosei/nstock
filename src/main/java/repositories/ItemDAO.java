/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author iamdveloper
 */
public class ItemDAO {

    private Connection conn = null;

    public ItemDAO(Connection conn) {

        this.conn = conn;
    }
    
    
    
    public int insertItem(Item item) throws Exception {

        try {
            // Insert query
            String query = "INSERT INTO items (genre_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getItemName());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
}
