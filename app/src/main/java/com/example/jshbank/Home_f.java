package com.example.jshbank;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Home_f extends Fragment {

    Button add_acc;
    ImageView ia,i2,i3,i4,i5,i6;
    CardView c1,c2,c3,c4,c5,c6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_f, container, false);

        // Find the button by its ID
        add_acc = view.findViewById(R.id.addac);
        ia = view.findViewById(R.id.im1);
        i2 = view.findViewById(R.id.im2);
        i3 = view.findViewById(R.id.im3);
        i4 = view.findViewById(R.id.im4);
        i5 = view.findViewById(R.id.im5);
        i6 = view.findViewById(R.id.im6);

        c1 = view.findViewById(R.id.cr1);
        c2 = view.findViewById(R.id.cr2);
        c3 = view.findViewById(R.id.cr3);
        c4 = view.findViewById(R.id.cr4);
        c5 = view.findViewById(R.id.cr5);
        c6 = view.findViewById(R.id.cr6);

        // Set onClickListener for the button
        add_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                Intent intent = new Intent(getActivity(), CreditCard.class);
                startActivity(intent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }


}