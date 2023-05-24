/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;

/**
 *
 * @author iamdveloper
 */
public class Technician {

    // DB Connection
    private Connection conn = null;
    private DB_Connection connection = new DB_Connection();

    //Manage items
    private ItemDAO manageItems = null;

    public Technician() {
        try {
            this.conn = connection.connect();
            this.manageItems = new ItemDAO(conn);

        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }
    }

    public void addItem() {
        
    }

    public void updateItem() {
    }

    public void deleteItem() {
    }

    public void getItem() {
    }

    public void getAllItems() {
    }

}
