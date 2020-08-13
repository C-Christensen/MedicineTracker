package com.example.mycapstoneproject;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MedicineRepository {
    private MedicineDao medDao;
    private LiveData<List<Medicine>> allNotes;

    public MedicineRepository(Application application){
        MedicineDatabase database = MedicineDatabase.getInstance(application);
        medDao = database.medDao();
        allNotes = medDao.getAllNotes();
    }

    public void insert(Medicine medicine){
        new InsertMedicineAsyncTask(medDao).execute(medicine);
    }

    public void update(Medicine medicine){
        new UpdateMedicineAsyncTask(medDao).execute(medicine);
    }

    public void delete(Medicine medicine){
        new DeleteMedicineAsyncTask(medDao).execute(medicine);
    }

    public void deleteAllNotes(){
        new DeleteAllMedicineAsyncTask(medDao).execute();
    }

    public LiveData<List<Medicine>> getAllNotes(){
        return allNotes;
    }

    private static class InsertMedicineAsyncTask extends AsyncTask<Medicine, Void, Void>{
        private MedicineDao medDao;

        private InsertMedicineAsyncTask(MedicineDao medDao){
            this.medDao = medDao;
        }
        @Override
        protected Void doInBackground(Medicine... medicines) {
           medDao.insert(medicines[0]);
           return null;
        }
    }

    private static class UpdateMedicineAsyncTask extends AsyncTask<Medicine, Void, Void>{
        private MedicineDao medDao;

        private UpdateMedicineAsyncTask(MedicineDao medDao){
            this.medDao = medDao;
        }
        @Override
        protected Void doInBackground(Medicine... medicines) {
            medDao.update(medicines[0]);
            return null;
        }
    }

    private static class DeleteMedicineAsyncTask extends AsyncTask<Medicine, Void, Void>{
        private MedicineDao medDao;

        private DeleteMedicineAsyncTask(MedicineDao medDao){
            this.medDao = medDao;
        }
        @Override
        protected Void doInBackground(Medicine... medicines) {
            medDao.delete(medicines[0]);
            return null;
        }
    }
    private static class DeleteAllMedicineAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicineDao medDao;

        private DeleteAllMedicineAsyncTask(MedicineDao medDao) {
            this.medDao = medDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            medDao.deleteAllNotes();
            return null;

        }

    }

}
