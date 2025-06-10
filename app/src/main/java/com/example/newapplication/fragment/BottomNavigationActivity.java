package com.example.newapplication.fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.newapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/*
 * This will the main activity for this bottom navigation example
 */
public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, homeFragment);
        fragmentTransaction.commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i("TAG", "onNavigationItemSelected: selectedId == " + item.getItemId());
                if (item.getItemId() == R.id.navHome) {
                    Log.i("TAG", "onNavigationItemSelected 1: hahaha");
                } else if (item.getItemId() == R.id.navUsers) {
                    Log.i("TAG", "onNavigationItemSelected 1: nav users");
                } else if (item.getItemId() == R.id.navChat) {
                    Log.i("TAG", "onNavigationItemSelected 1: nav chat");
                } else if (item.getItemId() == R.id.navProfile) {
                    Log.i("TAG", "onNavigationItemSelected 1: nav profile");
                }
                return true;
            }
        });
    }
}
