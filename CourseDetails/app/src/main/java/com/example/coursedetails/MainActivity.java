package com.example.coursedetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Spinner courseSpinner;
    private Button buttonShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        courseSpinner = findViewById(R.id.courseSpinner);
        buttonShowToast = findViewById(R.id.buttonShowToast);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.courses,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(adapter);

        buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedInfo();
            }
        });
    }

    private void showSelectedInfo() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // Month is 0-based
        int year = datePicker.getYear();

        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month, year);
        String selectedCourse = courseSpinner.getSelectedItem().toString();

        String message = "Joining Date: " + selectedDate + "\nCourse: " + selectedCourse;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}