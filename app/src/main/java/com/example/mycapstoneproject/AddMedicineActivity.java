package com.example.mycapstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddMedicineActivity extends AppCompatActivity {

    public static final String EXTRA_NAME =
            "com.example.mycapstoneproject.EXTRA_NAME";
    public static final String EXTRA_QUANTITY =
            "com.example.mycapstoneproject.EXTRA_QUANTITY";
    public static final String EXTRA_TYPE =
            "com.example.mycapstoneproject.EXTRA_TYPE";
    public static final String EXTRA_TIMESTAMP =
            "com.example.mycapstoneproject.EXTRA_TIMESTAMP";



    private EditText editTextName;
    private EditText editTextType;
    private EditText editTextQuantity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);



        editTextName = findViewById(R.id.edit_text_name);
        editTextQuantity = findViewById(R.id.edit_text_quantity);
        editTextType = findViewById(R.id.edit_text_type);



        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




    }

    private void saveMedicine(){
        String name = editTextName.getText().toString();
        String quantity = editTextQuantity.getText().toString();
        String type = editTextType.getText().toString();



        if(name.trim().isEmpty() || quantity.trim().isEmpty()){
            Toast.makeText(this,"Please insert text above", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_QUANTITY, quantity);
        data.putExtra(EXTRA_TYPE, type);

        setResult(RESULT_OK, data);
        finish();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveMedicine();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
