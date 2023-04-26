package com.example.picker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button showDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the DatePicker and Button views
        datePicker = findViewById(R.id.datePicker);
        showDateButton = findViewById(R.id.showDateButton);

        // Set an OnClickListener for the Button
        showDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected date from the DatePicker
                int year = datePicker.getYear();
                int month = datePicker.getMonth() + 1; // Month is zero-indexed
                int day = datePicker.getDayOfMonth();

                // Display the selected date as a Toast message
                String date = month + "/" + day + "/" + year;
                Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
