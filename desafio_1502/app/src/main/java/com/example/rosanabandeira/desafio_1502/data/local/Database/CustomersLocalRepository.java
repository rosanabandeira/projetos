package com.example.rosanabandeira.desafio_1502.data.local.Database;

import android.content.Context;

import com.example.rosanabandeira.desafio_1502.data.local.Dao.CustomersDao;
import com.example.rosanabandeira.desafio_1502.model.Customers;

import java.util.List;

import io.reactivex.Flowable;

public class CustomersLocalRepository {

    // Pega os dados da base de dados
    public Flowable<List<Customers>> customers(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase( context );
        CustomersDao customersDao = room.customersDao();
        return customersDao.getAll();
    }

    // Insere uma lista reults na base de dados
    public void insertItems(Context context, List<Customers> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase( context );
        CustomersDao customersDao = room.customersDao();
        customersDao.insert( items );
    }
}