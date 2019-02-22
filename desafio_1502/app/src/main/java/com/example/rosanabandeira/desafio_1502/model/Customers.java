package com.example.rosanabandeira.desafio_1502.model;

public class Customers {

    public String imageView = "";
    public String fullName = "";
    public String address = "";
    public String born = "";
    public String idUser = "";
    public Address addressResponse;

    public Customers() {
    }

    public Customers(String imageView, String fullName, String address, String born, String idUser) {
        this.imageView = imageView;
        this.fullName = fullName;
        this.address = address;
        this.born = born;
        this.idUser = idUser;

    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
