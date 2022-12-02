package com.example.tp1mobile;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //declaration des composantes
    EditText user_email, user_password;
    private Button validate, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //recuperation des composantes:

       user_email = findViewById(R.id.et_email_auth) ;
       user_password = findViewById(R.id.et_password_auth) ;
       validate = findViewById(R.id.bt_validate_auth) ;
       cancel = findViewById(R.id.bt_cancel_auth) ;


       cancel.setOnClickListener(view -> finish());

       validate.setOnClickListener(view -> {

           String email = user_email.getText().toString();
           String password = user_password.getText().toString();

           if(email.equals("test") && password.equals("000")){
               Log.d(TAG, "onCreate: "+email);
               Intent i = new Intent( MainActivity.this, Acceuil.class);
               i.putExtra("EMAIL",email);
               startActivity(i);
           }
       });




    }


}