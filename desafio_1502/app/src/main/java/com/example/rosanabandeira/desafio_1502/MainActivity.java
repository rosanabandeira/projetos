package com.example.rosanabandeira.desafio_1502;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rosanabandeira.desafio_1502.adapter.CustomAdapter;
import com.example.rosanabandeira.desafio_1502.data.local.Dao.CustomersDao;
import com.example.rosanabandeira.desafio_1502.model.Customers;
import com.example.rosanabandeira.desafio_1502.viewmodel.CustomerViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomerViewModel customerViewModel;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private Button buttonSave;
    private CustomersDao customersDao;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ImageView imageViewDelete;
    private List<Customers> customersList = new ArrayList<>();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        buttonSave = (Button) findViewById( R.id.buttonSave );
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        fab = (FloatingActionButton) findViewById( R.id.fabAddCustomer );
        imageViewDelete = (ImageView) findViewById( R.id.imageViewDelete );

        setSupportActionBar( toolbar );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        customerViewModel = ViewModelProviders.of( this ).get( CustomerViewModel.class );
        customerViewModel.init( this );


        customerViewModel.getArrayListMutableLiveData(this).observe( this, new Observer<ArrayList<CustomerViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<CustomerViewModel> customerViewModels) {

                customAdapter = new CustomAdapter( MainActivity.this, customerViewModels );
                recyclerView.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
                recyclerView.setAdapter( customAdapter );

            }
        } );

        customerViewModel.loadImage();

    }

}
