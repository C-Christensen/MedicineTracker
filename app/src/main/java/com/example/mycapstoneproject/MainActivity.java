package com.example.mycapstoneproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mAddMedicineButton;
    private MedicineViewModel noteViewModel;
    public static final int ADD_MEDICINE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MedicineAdapter adapter = new MedicineAdapter();
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("MedicineTracker");
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        break;
                    case R.id.nav_notes:
                        Intent intent1 = new Intent(MainActivity.this, NotesActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_maps:
                        Intent intent2 = new Intent(MainActivity.this, PermissionsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

        FloatingActionButton fab = findViewById(R.id.btn_add_medicine);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMedicineActivity.class);
                startActivityForResult(intent, ADD_MEDICINE_REQUEST);
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(MedicineViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Medicine>>() {
            @Override
            public void onChanged(List<Medicine> medicines) {
                adapter.setMedicines(medicines);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getMedicineAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Medicine Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.delete_all_notes:
                noteViewModel.deleteAllNotes();
                Toast.makeText(this,"All notes deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_MEDICINE_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(AddMedicineActivity.EXTRA_NAME);
            int quantity = data.getIntExtra(AddMedicineActivity.EXTRA_QUANTITY, 1);
            String type = data.getStringExtra(AddMedicineActivity.EXTRA_TYPE);



            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            String timestamp = currentDateTimeString;


            Medicine medicine = new Medicine(name, type, quantity, timestamp);
            noteViewModel.insert(medicine);

            Toast.makeText(this,"Medicine Saved", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Medicine not Saved", Toast.LENGTH_SHORT).show();
        }
    }



}
