package com.example.newapplication.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    Button actionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textViewExample);
        actionButton = findViewById(R.id.actionButton);

        registerForContextMenu(textView);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, actionButton);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.setting) {
            Toast.makeText(MenuActivity.this, "Select item selected", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.copy) {
            Toast.makeText(this, "Copy item selected", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.cut) {
            Toast.makeText(this, "Cut item selected", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.notification) {
            Toast.makeText(this, "Menu Notification Clicked", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.setting) {
            Toast.makeText(this, "Menu Setting clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
