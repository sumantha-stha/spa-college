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
                if (item.getItemId() == R.id.navHome) {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, homeFragment);
                    fragmentTransaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.navUsers) {
                    UserFragment userFragment = new UserFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, userFragment);
                    fragmentTransaction.commit();
                    return true;

                } else if (item.getItemId() == R.id.navChat) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, profileFragment);
                    fragmentTransaction.commit();
                    return true;

                } else if (item.getItemId() == R.id.navProfile) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, profileFragment);
                    fragmentTransaction.commit();
                    return true;
                }
                return true;
            }
        });
    }
}
