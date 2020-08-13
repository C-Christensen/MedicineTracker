package com.example.mycapstoneproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MedicineViewModel extends AndroidViewModel {
    private MedicineRepository repository;
    private LiveData<List<Medicine>> allNotes;
    public MedicineViewModel(@NonNull Application application) {
        super(application);
        repository = new MedicineRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Medicine medicine){
        repository.insert(medicine);
    }

    public void update(Medicine medicine){
        repository.update(medicine);
    }

    public void delete(Medicine medicine){
        repository.delete(medicine);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Medicine>> getAllNotes(){
        return allNotes;
    }
}
