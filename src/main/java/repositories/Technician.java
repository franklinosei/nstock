/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.ItemsModel;

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
//add items


    public int addItem(ItemsModel item) throws Exception {
        try {
            int rowsAffected = manageItems.insertItem(item);
            return rowsAffected;


        } catch (Exception ex) {
            throw new Exception("An error occurred while adding the item.", ex);
        }

    }
//update item
    public int updateItem(ItemsModel item) throws Exception {
        try {
            int rowsAffected = manageItems.updateItem(item);
            return rowsAffected;
        } catch (Exception ex) {
            throw new Exception("An error occured while updating the item", ex);
        }
    }
    
//delete item
    public int deleteItem(ItemsModel item) throws Exception {
        try {
            int rowsAffected = manageItems.deleteItem(item);
            return rowsAffected;
        } catch (Exception ex) {
            throw new Exception("Error occurred while deleting the item", ex);
        }
    }

    //fetch one item
//    public int getItem(ItemsModel item)throws Exception {
//        try{
//            int rowsAffected = manageItems.getItemID();
//            return rowsAffected;
//        }catch(Exception ex){
//            throw new Exception("Error occured while fetching items", ex);
//        }
//    }
    //fetch all items
    public ArrayList<ItemsModel> getAllItems(ItemsModel item) throws Exception {
        try {
            ArrayList<ItemsModel> itemsList = manageItems.getAllItems();
            return itemsList;
        } catch (Exception ex) {
            throw new Exception("Error occurred while deleting the item", ex);

        }
    }

}
