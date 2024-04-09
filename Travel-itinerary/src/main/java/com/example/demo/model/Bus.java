

package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "bus",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "vehicleType"})})
public class Bus implements Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleName;
    private String vehicleType = "car";
    private Float pricePerDay;
    private Integer capacity;
    private String driverInfo;
    private byte[] vehicleImage;

    // Implement Transport interface methods
    @Override
    public String getVehicleName() {
        return vehicleName;
    }

    @Override
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
   
    @Override
    public Float getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public void setPricePerDay(Float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
   
    @Override
    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getDriverInfo() {
        return driverInfo;
    }

    @Override
    public void setDriverInfo(String driverInfo) {
        this.driverInfo = driverInfo;
    }

    @Override
    public byte[] getVehicleImage() {
        return vehicleImage;
    }

    @Override
    public void setVehicleImage(byte[] vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    // Getters and setters for additional fields
    
}

