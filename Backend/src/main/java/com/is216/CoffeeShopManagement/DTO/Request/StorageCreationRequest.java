package com.is216.CoffeeShopManagement.DTO.Request;

import java.time.LocalDate;

public class StorageCreationRequest {

    private String name;
    private LocalDate dateReceived;
    private String manufacturer;
    private int quantity;

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateReceived(){
        return dateReceived;
    }
    
    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
