package com.example.jshbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    EditText edt_usrnm,edt_name,edt_paswrd,edt_phone,edt_email;
    Button button;
    TextView logReTxt;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    HashMap<String,String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edt_usrnm=findViewById(R.id.usernamereg);
        edt_email=findViewById(R.id.email);
        edt_paswrd=findViewById(R.id.passwordreg);
        edt_name=findViewById(R.id.fname);
        edt_phone=findViewById(R.id.phnumber);
        button=findViewById(R.id.signupButton);
        logReTxt=findViewById(R.id.lgReTxt);

        data=new HashMap<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseDatabase=FirebaseDatabase.getInstance();
                databaseReference=firebaseDatabase.getReference().child("MyData");


                String txt_name=edt_name.getText().toString().trim();
                String txt_phon=edt_phone.getText().toString().trim();
                String txt_pass=edt_paswrd.getText().toString().trim();
                String txt_email=edt_email.getText().toString().trim();
                String txt_usernm=edt_usrnm.getText().toString().trim();


                if (TextUtils.isEmpty(txt_usernm)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(txt_pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txt_name)) {
                    Toast.makeText(getApplicationContext(), "Enter Full name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txt_email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txt_phon)) {
                    Toast.makeText(getApplicationContext(), "Enter Phone Number!", Toast.LENGTH_SHORT).show();
                    return;
                }

                HelperClass helperClass = new HelperClass(txt_name,txt_email,txt_usernm,txt_pass,txt_phon);
                databaseReference.child(txt_usernm).setValue(helperClass);


                Toast.makeText(signup.this,"You have Signup successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(signup.this,home.class);
                startActivity(intent);


            }
        });

        logReTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}










