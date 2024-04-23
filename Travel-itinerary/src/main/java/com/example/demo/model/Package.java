package com.example.demo.model;
import java.util.List;
import com.example.demo.model.Transport;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.persistence.*;



@Entity
@Table(name="package")
public class Package {
    // there can be many hotels for one package, only one transport
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long packageId;
    private String packageName;
    private String description;
    
    @ManyToMany()
    @JoinTable(
        name = "package_hotel", // Name of the join table
        joinColumns = @JoinColumn(name = "package_id"), // Foreign key column in the join table for 'Package' entity
        inverseJoinColumns = @JoinColumn(name = "hotel_id") // Foreign key column in the join table for 'Hotel' entity
    )
    private List<Hotel> hotels;

    @OneToOne

    @JoinColumn(name = "transport_id")
    private Transport transport;
    private double price;
    private String baseLocation;
    

    private Package() {
        // hotels = new List<>();
        // apparently this is to avoid direct instantiation
    }
    public Long getPackageId(){
        return packageId;
    }
   
    public String getPackageName() {
        return this.packageName;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    // Getters and setters for hotels and transport
    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Transport getTransport() {
        return transport;
    }


    public static class Builder {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long packageId;
        private String packageName;
        private String description;
        private List<Hotel> hotels = new ArrayList<>();
        private Transport transport;
        private String baseLocation;
        private double price;

        public Builder() {
            // this.packageName = packageName;
        }

        public Long getPackageId(){
            return packageId;
        }
        
        public Builder setName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder setBaseLocation(String baseLocation) {
            this.baseLocation = baseLocation;
            return this;
        }

        public Builder addHotel(Hotel hotel) {
            this.hotels.add(hotel);
            return this;
        }

        
        public Builder transport(Transport transport) {
            this.transport = transport;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public String getName() {
            return this.packageName;
        }

        public String getBaseLocation() {
            return this.baseLocation;
        }

        public List<Hotel> getHotels() {
            return hotels;
        }
        
        public Transport getTransport() {
            return this.transport;
        }

        public Package build() {
            Package travelPackage = new Package();
            travelPackage.packageName = this.packageName;
            travelPackage.description = this.description;
            travelPackage.hotels = this.hotels;
            travelPackage.transport = this.transport;
            travelPackage.price = this.price;
            travelPackage.baseLocation = this.baseLocation;
            return travelPackage;
        }
    }

}


/*
Usage:  
Package travelPackage = new Package();

Hotel hotel1 = new Hotel("Hotel A", ...); // Instantiate Hotel with appropriate parameters
Hotel hotel2 = new Hotel("Hotel B", ...); // Instantiate another Hotel

Transport transport = new Transport("Flight XYZ", ...); // Instantiate Transport

travelPackage.addHotel(hotel1);
travelPackage.addHotel(hotel2);
travelPackage.setTransport(transport);

 */