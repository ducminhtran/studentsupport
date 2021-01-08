package com.meowbeos.studentsupport.activity.followbus;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meowbeos.studentsupport.R;



public class BusFragment extends Fragment {

    View view;
    CardView cvMap, cvMapOnGG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bus, container, false);

        initComponents();
        addEvents();

        return view;
    }

    private void initComponents() {
        cvMap = view.findViewById(R.id.cvMap);
        cvMapOnGG = view.findViewById(R.id.cvMapOnGG);
    }

    private void addEvents() {
        cvMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                MapFragment fragment = new MapFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
            }

        });

        cvMapOnGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}