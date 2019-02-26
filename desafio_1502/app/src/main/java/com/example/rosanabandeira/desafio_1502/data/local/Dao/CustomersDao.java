package com.example.rosanabandeira.desafio_1502.data.local.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rosanabandeira.desafio_1502.model.Customers;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CustomersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Customers customers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Customers> customers);

    @Update
    void update(Customers customers);

    @Delete
    void delete(Customers customers);

    @Query("Select * from customer limit 30")
    Flowable<List<Customers>> getAll();

}


