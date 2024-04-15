package com.example.jshbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.setting){
                    loadFragment(new SettingFragment(),false);

                } else  if(itemId == R.id.history){
                    loadFragment(new HistoryFragment(),false);

                } else  if(itemId == R.id.payment){
                    loadFragment(new PaymentFragment(), false);

                } else {
                    loadFragment(new Home_f(), true);
                }

                return true;
            }
        });



    }
    private  void loadFragment(Fragment fragment, boolean isAppInitialized){
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    if (isAppInitialized){
        fragmentTransaction.add(R.id.frameLayout, fragment);
    } else {
        fragmentTransaction.replace(R.id.frameLayout, fragment);

    }
    fragmentTransaction.commit();
}
}
