package com.example.mycapstoneproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicineDao {

    @Insert
    void insert(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Query("DELETE FROM medicine_table")
    void deleteAllNotes();

    @Query("SELECT * FROM medicine_table ORDER BY timestamp DESC")
    LiveData<List<Medicine>> getAllNotes();
}
