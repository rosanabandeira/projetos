package com.example.rosanabandeira.desafio_1502;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rosanabandeira.desafio_1502.adapter.CustomAdapter;
import com.example.rosanabandeira.desafio_1502.model.Customers;
import com.example.rosanabandeira.desafio_1502.viewmodel.CustomerViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomerViewModel customerViewModel;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerview );
        customerViewModel = ViewModelProviders.of( this ).get( CustomerViewModel.class );

        customerViewModel.getArrayListMutableLiveData().observe( this, new Observer<ArrayList<CustomerViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<CustomerViewModel> customerViewModels) {

                customAdapter = new CustomAdapter( MainActivity.this, customerViewModels );
                recyclerView.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
                recyclerView.setAdapter( customAdapter );

            }
        } );

        customerViewModel.loadImage(  );

    }

}
