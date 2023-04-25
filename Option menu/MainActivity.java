package com.example.xyzactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.learn,menu);

        //if(menu instanceof MenuBuilder)
        //{
        //    MenuBuilder m = (MenuBuilder) menu;
        //    m.setOptionalIconsVisible(true);
        //}

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id)
        {
            case R.id.b1:
                Toast.makeText(this, "option1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.b2:
                Toast.makeText(this, "Option 2 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.b3:
                Toast.makeText(this, "Option 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.home:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}