package com.example.newapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.newapplication.fragment.MainFragment;

/**
 * This is the main activity for the fragment, where fragments are placed.
 */

public class FragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        /*
         * MainFragment is the new fragment class.
         * Fragment Manager is responsible to manage the fragment i.e. add, remove, replace, etc
         * Fragment Transaction helps to begin the fragment transaction
         * After the fragmentTransaction.commit(): the fragment is committed or placed on the activity
         */
        MainFragment mainFragment = new MainFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /*
         * This lines specify where to put the fragment in the activity layout and which fragment to put
         * .add takes two parameter as input: 1. container -> where fragment is set. that is frame layout
         * 2. Fragment: which fragment to set on the container
         */
        fragmentTransaction.add(R.id.container, mainFragment);
        fragmentTransaction.commit();
    }
}
