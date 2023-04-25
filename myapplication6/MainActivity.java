package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name, age;


 Button button;
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);    // for shared pref
        age = findViewById(R.id.age);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { //passing data through intent
            @Override
            public void onClick(View view) {
                String name="Rupesh the rizzler";
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("x",name);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onResume() {          //shared prefrence
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);

        // Setting the fetched data in the EditTexts
        name.setText(s1);
        age.setText(String.valueOf(a));
    }
    @Override
    protected void onPause() {       //shared preference
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {          // normal menu code
        getMenuInflater().inflate(R.menu.example_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_contact:
                Toast.makeText(getApplicationContext(), "Add contact selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favorite:
                Toast.makeText(getApplicationContext(), "Favorite selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.give_feedback:
                Toast.makeText(getApplicationContext(), "Give feedback selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}