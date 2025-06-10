package com.example.newapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newapplication.R;

/**
 * By extending Fragment, we can access the fragments method & declare the class as fragment (Same as AppCompactActivity)
 */
public class MainFragment extends Fragment {

    /**
     * @param inflater           The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * <p>
     * We use @onCreateView to initialize widget or to bind the widgets
     * @return
     */

    Button buttonNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
         * to Set the layout or xml file in place of setContentView as in activity,we need to create views.
         * To Create the view, you to to inflate the layout
         * inflater.inflate takes 3 inputs
         * 1. layout id: the layout that is place or the current fragment class
         * 2. container: where to put the current fragment, in viewGroup which is given by the method itself
         * 3. attachToRoot: false
         * Views should be return for view to be visible for the users.
         */

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonNext = view.findViewById(R.id.buttonNext);

        SecondFragment secondFragment = new SecondFragment();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
            }
        });
    }
}
