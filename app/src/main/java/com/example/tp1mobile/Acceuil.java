package com.example.tp1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acceuil extends AppCompatActivity {


    // declaration des composantes
     private Button btn_add , btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        //Recuperation des composantes:
        btn_add= findViewById(R.id.bt_add_acceuil);
        btn_edit = findViewById(R.id.bt_edit_acceuil);


        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String mail= b.getString("EMAIL");
        // i can use it as "email  du monsieur ..."

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( Acceuil.this, Add.class);
                startActivity(i);            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( Acceuil.this, Edit.class);
                startActivity(i);

            }
        });
    }
}