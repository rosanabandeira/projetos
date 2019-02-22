package com.example.rosanabandeira.desafio_1502.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.rosanabandeira.desafio_1502.AddressActivity;
import com.example.rosanabandeira.desafio_1502.model.AddressResponse;

public class ZipCodeListener implements TextWatcher {
    private Context context;

    public ZipCodeListener( Context context ){
        this.context = context;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String zipCode = editable.toString();

        if( zipCode.length() == 8 ){
            new AddressResponse( (AddressActivity) context ).execute();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
}