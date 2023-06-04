package models;

public class ItemsModel {
    private int itemID;
    private String name;
    private String description;
    private boolean faulty;
    private int typeID;
    private String itemscol;
    private String photo;
    private String serialNumber;
    private int labID;
    private int managerID;
    private int specID;
    private boolean deleted;

    public ItemsModel() {
        // Default constructor
    }

    public ItemsModel(int itemID, String photo, String name, String description, boolean faulty, int typeID, String serialNumber, int labID, int managerID, int specID, boolean deleted) {
    this.itemID = itemID;
    this.name = name;
    this.description = description;
    this.faulty = faulty;
    this.typeID = typeID;
    this.serialNumber = serialNumber;
    this.labID = labID;
    this.managerID = managerID;
    this.specID = specID;
    this.deleted = deleted;
    this.photo = photo;
}


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFaulty() {
        return faulty;
    }

    public void setFaulty(boolean faulty) {
        this.faulty = faulty;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getItemscol() {
        return itemscol;
    }

    public void setItemscol(String itemscol) {
        this.itemscol = itemscol;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getLabID() {
        return labID;
    }

    public void setLabID(int labID) {
        this.labID = labID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
