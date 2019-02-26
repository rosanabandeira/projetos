package com.example.rosanabandeira.desafio_1502.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "customer")
public class Customers {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @Ignore
    public String imageView = "";

    @ColumnInfo(name = "Nome Completo")
    public String fullName = "";

    @ColumnInfo(name = "Endereço")
    public String address = "";

    @ColumnInfo(name = "Data de Nascimento")
    public String born = "";

    @ColumnInfo(name = "CPF")
    public String idUser = "";


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
