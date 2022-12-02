package com.example.tp1mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db = null;
    Context con;

    ContactManager( Context con){
        this.con = con;

    }

    public void ouvrir()
    {
        ContactHelper helper = new ContactHelper(con, "mabase.db",null,5);
        db = helper.getWritableDatabase();


    }
    public long ajout(int phone,String first, String last){
        long a =0;
        ContentValues values = new ContentValues();
        values.put(ContactHelper.col_phone,phone);
        values.put(ContactHelper.col_firstName, first);
        values.put(ContactHelper.col_lastName,last);
        a = db.insert(ContactHelper.table_contact,null,values);

        return a;

    }

    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> l = new ArrayList<Contact>();

        Cursor cr=db.query( ContactHelper.table_contact,
                new String[]{
                        ContactHelper.col_phone,
                        ContactHelper.col_firstName,
                        ContactHelper.col_lastName},null,null,null,null,null);
        cr.moveToFirst();
        while(!cr.isAfterLast()){
        String i1= cr.getString(0);
        String i2= cr.getString(1);
        String i3= cr.getString(2);
        l.add(new Contact(i1,i2,i3));

        cr.moveToNext();
    }
    return l;

    }

    public void supprimer(){

    }

    public  void fermer(){}


}
