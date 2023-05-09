package com.example.radio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView selectedOptionText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String selectedOption = getIntent().getStringExtra("selectedOption");
        String name = getIntent().getStringExtra("name");

        TextView optionTextView = findViewById(R.id.selected_option_text_view);
        optionTextView.setText("Selected Option: " + selectedOption);

        TextView nameTextView = findViewById(R.id.name_text_view);
        nameTextView.setText("Name: " + name);

        return;
    }
}
