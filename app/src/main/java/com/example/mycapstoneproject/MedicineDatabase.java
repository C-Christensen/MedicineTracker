package com.example.mycapstoneproject;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Medicine.class, version = 1, exportSchema = false)
public abstract class MedicineDatabase extends RoomDatabase {

    private static MedicineDatabase instance;

    public abstract MedicineDao medDao();

    public static synchronized MedicineDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
            MedicineDatabase.class, "medicine_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicineDao medDao;

        private PopulateDbAsyncTask(MedicineDatabase db){
            medDao = db.medDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            medDao.insert(new Medicine("Ibuprofen", "pill", 1, "08/01/2019"));
            return null;
        }
    }
}
