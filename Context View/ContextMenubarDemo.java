package com.example.xyzactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextMenubarDemo extends AppCompatActivity {
    ListView contacts_list;
    String[] contacts = {"Rohit","Josh","Rupesh","Viswam","Koushik","Jaison"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menubar_demo);


        contacts_list = (ListView) findViewById(R.id.contacts_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        contacts_list.setAdapter(adapter);

        registerForContextMenu(contacts_list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

       getMenuInflater().inflate(R.menu.context_menubar,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.call:
                Toast.makeText(this, "calling", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.message:
                Toast.makeText(this, "Messaging", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}