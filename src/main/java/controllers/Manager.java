/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.LabsModel;
import models.TechnicianModel;
import repositories.LabDAO;
import repositories.TechnicianDAO;

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
    public int addLab(LabsModel lab) throws Exception {
        try {
            int rowsAffected = manageLabs.insertLab(lab);
            return rowsAffected;

        } catch (Exception ex) {
            throw new Exception("An error occurred while adding the lab.", ex);
        }
    }

    public int updateLab(LabsModel lab) throws Exception {
        try {
            int rowsAffected = manageLabs.updateLab(lab);
            return rowsAffected;
        } catch (Exception ex) {
            throw new Exception("An error occured while updating the item", ex);
        }
    }

    public int deleteLab(LabsModel lab) throws Exception {
        try {
            int rowsAffected = manageLabs.deleteLab(lab);
            return rowsAffected;
        } catch (Exception ex) {
            throw new Exception("An error occured while updating the item", ex);
        }
    }

//    public void viewLab() {
//    }
    public List<LabsModel> getAllLabs() throws Exception {
        try {
            List<LabsModel> labsList = manageLabs.getAllLabs();
            return labsList;
        } catch (Exception ex) {
            throw new Exception("Error occurred while deleting the item", ex);

        }
    }

//    Technicians
    public int addTechnician(TechnicianModel techie) throws Exception {
        try {
            int rowsAffected = manageTechnicians.insertTechnician(techie);
            return rowsAffected;

        } catch (Exception ex) {
            throw new Exception("An error occurred while adding the technician." + ex.getMessage());
        }
    }

    public int updateTechnician(TechnicianModel techie) throws Exception {
        try {
            int rowsAffected = manageTechnicians.insertTechnician(techie);
            return rowsAffected;

        } catch (Exception ex) {
            throw new Exception("An error occurred while updating technician " + ex.getMessage());
        }
    }

    public int deleteTechnician(TechnicianModel techie) throws Exception {
        try {
            int rowsAffected = manageTechnicians.deleteTechnician(techie);
            return rowsAffected;
        } catch (Exception ex) {
            throw new Exception("An error occured while deleting the technician " + ex.getMessage());
        }
    }

//    public void getTechnician() {
//    }
    public ArrayList<TechnicianModel> getAllTechnicians() throws Exception {
        try {
            ArrayList<TechnicianModel> techsList = manageTechnicians.getAllTechnicians();
            return techsList;
        } catch (Exception ex) {
            throw new Exception("Error occurred while deleting the item", ex);

        }
    }

}
