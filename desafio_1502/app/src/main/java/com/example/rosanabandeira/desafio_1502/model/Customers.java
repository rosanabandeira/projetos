package com.example.rosanabandeira.desafio_1502.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
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

    @ColumnInfo(name = "Data de Nascimento")
    public String born = "";

    @ColumnInfo(name = "CPF")
    public String idUser = "";

    @Embedded
    public Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Customers() {
        this.address = new Address();

    }


    public Customers(String imageView, String fullName, String born, String idUser) {
        this();
        this.imageView = imageView;
        this.fullName = fullName;
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
