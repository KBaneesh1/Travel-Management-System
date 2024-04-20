// Transport.java
package com.example.demo.model;

public interface Transport {
    String getVehicleName();
    void setVehicleName(String vehicleName);

    String getvehicleType();
    
    Float getPricePerDay();
    void setPricePerDay(Float pricePerDay);

    String getBaseLocation();
    void setBaseLocation(String location);
   
    
    Integer getCapacity();
    void setCapacity(Integer capacity);
    
    String getDriverInfo();
    void setDriverInfo(String driverInfo);

    byte[] getVehicleImage();
    void setVehicleImage(byte[] vehicleImage);
}

