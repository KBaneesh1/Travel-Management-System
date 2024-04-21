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

    private User user;
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
