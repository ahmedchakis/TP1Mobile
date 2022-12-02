package com.example.tp1mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {

    public static final String table_contact = "Contacts";
    public static final String col_phone = "Phone";
    public static final String col_firstName = "FirstName";
    public static final String col_lastName = "LastName";


    String requete = "create table "+table_contact+"("+col_phone+" Text Primary Key," +col_firstName+" Text not null,"+col_lastName+" Text not null);";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         //create db first time
        db.execSQL(requete);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //version change
        db.execSQL(" drop table "+table_contact);
        onCreate(db);
    }

}
