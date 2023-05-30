package models;

import java.sql.Timestamp;

public class LabsModel {
    private int labID;
    private String labName;
    private String city;
    private String region;
    private String photo;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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

    public LabsModel(int labID, String labName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public String getPhotoUrl() {
//        // Assuming the photo URL is the same as the photo field
//        return photo;
//    }
}
