package com.example.rosanabandeira.desafio_1502;


import android.databinding.ObservableField;
import android.media.Image;
import android.view.View;

public class CustomerViewModel extends ObservableField {

    public ObservableField<Image> imageView = new ObservableField<>();
    public ObservableField<String> fullName = new ObservableField<>();
    public ObservableField<String> address = new ObservableField<>();
    public ObservableField<String> born = new ObservableField<>();
    public ObservableField<String> idUser = new ObservableField<>();


}