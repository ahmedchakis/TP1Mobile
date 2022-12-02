package com.example.tp1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    //Declaration des composantes:
     EditText name, lastName, phone;
     private Button add, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Recupération des composantes:
        name= findViewById(R.id.et_name_add);
        lastName= findViewById(R.id.et_lastName_add);
        phone= findViewById(R.id.et_phone_add);
        add= findViewById(R.id.bt_add_add);
        cancel= findViewById(R.id.bt_cancel_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameAdded = name.getText().toString();
                String lastNameAdded = lastName.getText().toString();
                String phoneAdded = phone.getText().toString();


              //  if(nameAdded.equalsIgnoreCase("test") && lastNameAdded.equals("test") && phoneAdded.equals("00000000")){
                    if(!phoneAdded.equals("00000000")){

                        ContactManager  manage= new ContactManager(Add.this);
                        manage.ouvrir();
                       manage.ajout(Integer.parseInt(phoneAdded),nameAdded,lastNameAdded);

                        ArrayList<Contact> l = manage.getAllContacts();

                        /*

                        System.out.println("--------------------");
                        System.out.println(l.get(0).name);
                        System.out.println(l.get(0).phone);
                        System.out.println(l.get(0).lastName);
                        System.out.println("--------------------");

                        */



                        Intent i = new Intent( Add.this, Edit.class);
                    startActivity(i);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}