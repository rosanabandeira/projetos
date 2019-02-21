package com.example.rosanabandeira.desafio_1502.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.rosanabandeira.desafio_1502.R;
import com.example.rosanabandeira.desafio_1502.model.Customers;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomerViewModel extends ViewModel {

    public String imageView = "";
    public String fullName = "";
    public String address = "";
    public String born = "";
    public String idUser = "";

    public CustomerViewModel() {

    }

    public MutableLiveData<ArrayList<CustomerViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    private ArrayList<CustomerViewModel> arrayList;

    public String getImageUrl() {
        return "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})


    public static void loadImage(ImageView imageView, String imageUrl) {

        Picasso.get()
                .load( imageUrl )
                .into( imageView );

    }

    public CustomerViewModel(Customers customers) {

        this.imageView = customers.imageView;
        this.fullName = customers.fullName;
        this.address = customers.address;
        this.born = customers.born;
        this.idUser = customers.idUser;

    }

    public MutableLiveData<ArrayList<CustomerViewModel>> getArrayListMutableLiveData() {

        arrayList = new ArrayList<>();

        Customers customers = new Customers( getImageUrl(), "Andre", "Rua Boa Vista", "19/02/89", "123.456.789-00" );

        CustomerViewModel customerViewModel = new CustomerViewModel( customers );

        arrayList.add( customerViewModel );

        arrayListMutableLiveData.setValue( arrayList );

        return arrayListMutableLiveData;
    }
}