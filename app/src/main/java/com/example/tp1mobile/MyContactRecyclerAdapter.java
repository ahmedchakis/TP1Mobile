package com.example.tp1mobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyContactRecyclerAdapter extends RecyclerView.Adapter<MyContactRecyclerAdapter.MyViewHolder> {

    Context con ;
    ArrayList <Contact> data;

    public MyContactRecyclerAdapter(Context con, ArrayList<Contact> data) {
        this.con = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(con);
        View v= View.inflate(con,R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact c = data.get(position);
        holder.tvName.setText(c.name);
        holder.tvLastName.setText(c.lastName);
        holder.tvPhone.setText(c.phone);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvLastName,tvPhone;
        public  ImageView img_call , img_del;
        public MyViewHolder(@NonNull View v) {
            super(v);
             tvName = v.findViewById(R.id.tv_name_contact);
             tvLastName = v.findViewById(R.id.tv_lastname_contact);
            tvPhone = v.findViewById(R.id.tv_phone_contact);

             img_call = v.findViewById(R.id.im_call_contact);
            img_del = v.findViewById(R.id.im_delete_contact);

            //evenement:

            img_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice= getAdapterPosition();
                    data.remove(indice);
                    notifyDataSetChanged();
                }
            });

            img_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+data.get(getAdapterPosition()).phone));
                    con.startActivity(i);

                }
            });
        }
    }
}
