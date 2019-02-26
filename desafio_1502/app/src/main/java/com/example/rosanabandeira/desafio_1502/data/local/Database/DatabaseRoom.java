package com.example.rosanabandeira.desafio_1502.data.local.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.rosanabandeira.desafio_1502.data.local.Dao.CustomersDao;
import com.example.rosanabandeira.desafio_1502.model.Customers;

@Database(entities = {Customers.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)

public abstract class DatabaseRoom extends RoomDatabase {

    public abstract CustomersDao customersDao();

    private static volatile DatabaseRoom INSTANCE;

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            DatabaseRoom.class, "sqlite_room_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
