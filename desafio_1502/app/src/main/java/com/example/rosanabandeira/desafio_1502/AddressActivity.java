package com.example.rosanabandeira.desafio_1502;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.rosanabandeira.desafio_1502.databinding.ActivityAdressBinding;
import com.example.rosanabandeira.desafio_1502.viewmodel.CustomerViewModel;
import com.facebook.stetho.common.Util;

public class AddressActivity extends AppCompatActivity {

    private EditText etZipCode;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        ActivityAdressBinding activityAdressBinding = DataBindingUtil.setContentView(this, R.layout.activity_adress );

        activityAdressBinding.setCustomermodel( new CustomerViewModel(  ) );

        activityAdressBinding.executePendingBindings();

    }
}
