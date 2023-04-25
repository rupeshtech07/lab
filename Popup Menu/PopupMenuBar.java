package com.example.xyzactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuBar extends AppCompatActivity {
    Button popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_bar);

        popup = (Button) findViewById(R.id.popup);

    }
    public void openPopUpMenuBar(View view)
{
    PopupMenu popupMenu = new PopupMenu(PopupMenuBar.this,popup);
    popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());

    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //Toast.makeText(PopupMenuBar.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            int id = item.getItemId();
            switch (id)
            {
                case R.id.b1:
                    Toast.makeText(PopupMenuBar.this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.b2:
                    Toast.makeText(PopupMenuBar.this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.b3:
                    Toast.makeText(PopupMenuBar.this, "Option 3 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    Toast.makeText(PopupMenuBar.this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
            }

        }
    });
    popupMenu.show();
}
}