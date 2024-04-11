// Transport.java
package com.example.demo.model;

public interface Transport {
    String getVehicleName();
    void setVehicleName(String vehicleName);

    Float getPricePerDay();
    void setPricePerDay(Float pricePerDay);

   
    
    Integer getCapacity();
    void setCapacity(Integer capacity);
    
    String getDriverInfo();
    void setDriverInfo(String driverInfo);

    Integer getAvailableVehicle();
    void setAvailableVehicle(Integer available_vehicles);

    byte[] getVehicleImage();
    void setVehicleImage(byte[] vehicleImage);
}

