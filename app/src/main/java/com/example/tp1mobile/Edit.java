package com.example.tp1mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    ArrayList <Contact> alldata = new ArrayList<Contact>();
    ArrayList <Contact> data = new ArrayList<Contact>();
    RecyclerView rev;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        rev = findViewById(R.id.rv);
        ContactManager  manage= new ContactManager(Edit.this);
        manage.ouvrir();
        data = manage.getAllContacts();
        alldata = manage.getAllContacts();

        search=findViewById(R.id.et_search_edit);



        MyContactRecyclerAdapter ad = new MyContactRecyclerAdapter(Edit.this, data);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = String.valueOf(search.getText());
                System.out.println(s);

                data.clear();

                for (Contact c : alldata) {
                    if (c.phone.contains(s) || c.name.contains(s)|| c.lastName.contains(s)) {
                        data.add(c);
                    }
                }
                ad.notifyDataSetChanged();
            }
        });

        //LinearLayoutManager manager = new LinearLayoutManager(Edit.this, LinearLayoutManager.HORIZONTAL,true);
        //exemple 2:
         GridLayoutManager manager = new GridLayoutManager(Edit.this,1,GridLayoutManager.VERTICAL,false);
        rev.setLayoutManager(manager);

        rev.setAdapter(ad);

    }
}