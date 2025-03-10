package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class StorageCreationRequest {
    private String name;
    @Column(name = "dateReceived")
    private String dateReceived;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "quantity")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
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
