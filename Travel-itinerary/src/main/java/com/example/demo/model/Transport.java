// Transport.java

// public class Transport {
//     String getVehicleName();
//     void setVehicleName(String vehicleName);

//     String getvehicleType();
    
//     Float getPricePerDay();
//     void setPricePerDay(Float pricePerDay);

//     String getBaseLocation();
//     void setBaseLocation(String location);
   
    
//     Integer getCapacity();
//     void setCapacity(Integer capacity);
    
//     String getDriverInfo();
//     void setDriverInfo(String driverInfo);

//     byte[] getVehicleImage();
//     void setVehicleImage(byte[] vehicleImage);
// }

package com.example.demo.model;
import java.io.Serializable;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transport")
public class Transport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transport_id")
    private Long id;
    
    @Column(name = "vehicle_name")
    private String vehicleName;
    
    @Column(name = "vehicle_type")
    private String vehicleType;
    
    @Column(name = "price_per_day")
    private Float pricePerDay;
    
    @Column(name = "capacity")
    private Integer capacity;
    
    @Column(name = "driver_info")
    private String driverInfo;
    
    @Column(name = "base_location")
    private String baseLocation;
    
    @Column(name = "vehicle_image")
    private byte[] vehicleImage;

    // Getters and setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(String driverInfo) {
        this.driverInfo = driverInfo;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public byte[] getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(byte[] vehicleImage) {
        this.vehicleImage = vehicleImage;
    }
}
