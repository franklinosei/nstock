/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */

public class SpecificationModel {
    private int specID;
    private int ramSize;
    private int storageSize;
    private float screenSize;

    public SpecificationModel() {
        // Default constructor
    }

    public SpecificationModel(int specID, int ramSize, int storageSize, float screenSize) {
        this.specID = specID;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.screenSize = screenSize;
    }

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
}

//