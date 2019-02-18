package com.example.rosanabandeira.desafio_1502;

import android.widget.Button;

public class Customer {

    private String imageView;
    private String fullName;
    private String address;
    private String born;
    private String idUser;
    private Button editButton;


    public Customer(String imageView, String fullName, String address, String born, String idUser) {
        this.imageView = imageView;
        this.fullName = fullName;
        this.address = address;
        this.born = born;
        this.idUser = idUser;
        this.editButton = editButton;

    }

    public String getImageView() {
        return imageView;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getBorn() {
        return born;
    }

    public String getIdUser() {
        return idUser;
    }

    public Button getEditButton(){
        return editButton;
    }


}
