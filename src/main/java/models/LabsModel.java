/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */

public class LabsModel {
    private int labID;
    private String labName;
    private String city;
    private String region;
    private String photo;

    public LabsModel() {
        // Default constructor
    }

    public LabsModel(int labID, String labName, String city, String region, String photo) {
        this.labID = labID;
        this.labName = labName;
        this.city = city;
        this.region = region;
        this.photo = photo;
    }

    public int getLabID() {
        return labID;
    }

    public void setLabID(int labID) {
        this.labID = labID;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

//