package com.example.jshbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.health.connect.datatypes.SleepSessionRecord;
import android.os.Bundle;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        Thread th=new Thread(){
            public void run(){
                try {
                  sleep(1000);

                } catch (Exception e){
                    e.printStackTrace();

                }
                finally {
                    Intent intent=new Intent(splashactivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        };th.start();

    }
}