package com.example.tp1mobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {


    Context con;
    ArrayList <Contact> data;

    public MyListViewAdapter(Context con, ArrayList<Contact> data) {
        //
        this.con = con;
        this.data = data;
    }


    @Override

    public int getCount() {
        //elle renvoie le nombre de vues à créer
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        //renvoie la donnée dans la position i
        return null;
    }

    @Override
    public long getItemId(int i) {
        //retourne l'id de l'élt
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //renvoie view à afficher
        //creation d'un view
        LayoutInflater inf = LayoutInflater.from(con);
        View v= View.inflate(con,R.layout.view_contact,null);


        //recuperation des holders:
        TextView tvName = v.findViewById(R.id.tv_name_contact);
        TextView tvLastName = v.findViewById(R.id.tv_lastname_contact);
        TextView tvPhone = v.findViewById(R.id.tv_phone_contact);

        ImageView img_call = v.findViewById(R.id.im_call_contact);
        ImageView img_del = v.findViewById(R.id.im_delete_contact);


        //affectation des holders
         Contact c = data.get(i);
         tvName.setText(c.name);
         tvLastName.setText(c.lastName);
         tvPhone.setText(c.phone);


         //evenment
        img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              data.remove(i);
              notify();

            }
        });

        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_DIAL);
               i.setData(Uri.parse("tel:"+c.phone));
               con.startActivity(i);

            }
        });

        return v;
    }
}
