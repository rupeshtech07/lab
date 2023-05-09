package com.example.radio;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button submitButton;
    private Button viewButton;
    private EditText nameEditText;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database
        database = openOrCreateDatabase("myDatabase", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS UserInfo(name TEXT, option TEXT);");

        // Initialize the views
        radioGroup = findViewById(R.id.radio_group);
        submitButton = findViewById(R.id.submit_button);
        viewButton = findViewById(R.id.view_button);
        nameEditText = findViewById(R.id.name_edit_text);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton radioButton = findViewById(selectedId);
                String selectedOption = radioButton.getText().toString();

                String name = nameEditText.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert the user info into the database
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("option", selectedOption);
                long result = database.insert("UserInfo", null, values);
                if (result == -1) {
                    Toast.makeText(MainActivity.this, "Failed to insert user info into database", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "User info saved successfully", Toast.LENGTH_SHORT).show();
                    nameEditText.setText("");
                    radioGroup.clearCheck();
                }

                // Launch the second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("selectedOption", selectedOption);
                intent.putExtra("name", name);

                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = database.rawQuery("SELECT * FROM UserInfo", null);
                if (cursor.moveToFirst()) {
                    do {
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String option = cursor.getString(cursor.getColumnIndex("option"));
                        Log.d("MainActivity", "Name: " + name + " Option: " + option);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
