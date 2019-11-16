package com.example.navigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    Button first,second;
    private NavController navController;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        first=view.findViewById(R.id.firstFragmentID);
        second=view.findViewById(R.id.secondFragmentID);
        navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        first.setOnClickListener(this);
        second.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==first){

            Navigation.findNavController(v).navigate(R.id.action_homeId_to_fragment_One);
        }
        else if (v==second){
            Navigation.findNavController(v).navigate(R.id.action_homeId_to_fragment_Two);
            NavigationUI.setupActionBarWithNavController((AppCompatActivity) getActivity(),navController);
        }
    }
}
