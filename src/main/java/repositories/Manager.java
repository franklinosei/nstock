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
public class Manager extends Technician {

    // DB Connection
    private Connection conn = null;
    private DB_Connection connection = new DB_Connection();

    private TechnicianDAO manageTechnicians = null;
    private LabDAO manageLabs = null;

    public Manager() {
        super();
        try {
            this.conn = connection.connect();
            this.manageTechnicians = new TechnicianDAO(this.conn);
            this.manageLabs = new LabDAO(this.conn);

        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }
    }

//    Labs
    public void addLab() {
    }

    public void updateLab() {
    }

    public void deleteLab() {
    }

    public void viewLab() {
    }
    
    public void getAllLabs() {}

//    Technicians
    public void addTechnician() {
    }

    public void updateTechnician() {
    }

    public void deleteTechnician() {
    }

    public void getTechnician() {
    }
    
    public void getAllTechnicians() {}
}
