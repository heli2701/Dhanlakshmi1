package com.example.jshbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText user, password;
    Button btn;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.loginButton);
        textView = findViewById(R.id.signupText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUsername() | !validatePassword()){

                } else {
                    checkUser();
                }
            }
        });

        //while click on sign up go on sign_up page
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });

    }


    public Boolean validateUsername() {
        String val = user.getText().toString();
        if (val.isEmpty()) {
            user.setError("Enter Username");
            return false;
        } else {
            user.setError(null);
            return true;

        }
    }
    public Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Enter password");
            return false;
        } else {
            password.setError(null);
            return true;

        }
    }
    public void checkUser(){
        String userUsername = user.getText().toString().trim();
        String userPass = password.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("MyData");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    user.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if(!Objects.equals(passwordFromDB,userPass)){
                        user.setError(null);
                        Intent intent = new Intent(MainActivity.this, home.class);
                        startActivity(intent);
                    }
                    else{
                        password.setError("Invalid Credentials");
                        password.requestFocus();
                    }
                }
                else{
                    user.setError("user does not exist");
                    user.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}