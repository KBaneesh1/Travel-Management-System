package com.example.demo.model;

import java.util.ArrayList;
import java.util.Optional;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class UserPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_package_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // @ManyToMany
    // @JoinTable(
    //     name = "booked", // Name of the join table
    //     joinColumns = @JoinColumn(name = "user_id"), // Foreign key column in the join table for 'Package' entity
    //     inverseJoinColumns = @JoinColumn(name = "package_id") // Foreign key column in the join table for 'Hotel' entity
    // )
    @OneToOne
    @JoinColumn(name = "package_id")
    private Package pack;

    public Long getUser_package_id() {
        return user_package_id;
    }
    public void setUser_package_id(Long user_package_id) {
        this.user_package_id = user_package_id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Package getPack() {
        return pack;
    }
    public void setPack(Package pack2) {
        this.pack = pack2;
    }
}
