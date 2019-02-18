package com.example.rosanabandeira.desafio_1502;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ActivityCustomerBinding binding;
    CustomerViewModel customerViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        customerViewModel = new CustomerViewModel();

        binding = DataBindingUtil.setContentView(this, R.layout.customer_details);
        binding.CustomerViewModel(customerViewModel);


    }

}
