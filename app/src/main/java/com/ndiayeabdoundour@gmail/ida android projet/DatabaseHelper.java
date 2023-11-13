package com.ndiayeabdoundour@gmail.projet1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

  public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "bdetudiant.db";
    public static final String TABLE_NAME = "etudiant";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "PRENOM";
    public static final String COL_3 = "NOM";
    public static final String COL_4 = "NOTES";


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, PRENOM TEXT, NOM TEXT, NOTES TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String prenom, String nom, String note){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, prenom);
        values.put(COL_3, nom);
        values.put(COL_4, note);
        long resultat= db.insert(TABLE_NAME, null, values);
        Log.i("##### check insert", " result"+resultat);
        if (resultat== -1)return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res= db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return res;
    }
    // Mise a jour d'un enregistrement
    public boolean updateData(String id, String nom, String prenom, String note){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_1, id);
        valeurs.put(COL_2, prenom);
        valeurs.put(COL_1, nom);
        valeurs.put(COL_1, note);
        db.update(TABLE_NAME, valeurs, "ID = ?", new String[]{id});
        return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

      
}
