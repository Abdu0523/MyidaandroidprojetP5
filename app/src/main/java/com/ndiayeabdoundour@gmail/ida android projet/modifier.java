package com.ndiayeabdoundour@gmail.projet1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class modifier extends AppCompatActivity {

    DatabaseHelper myDb;

    Button buttonViewUpdate;

    EditText editTextPrenom, editTextNom, editTextNote, editTextId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        myDb= new DatabaseHelper(this);
        editTextNom= (EditText)findViewById(R.id.editTextNom);
        editTextPrenom=(EditText)findViewById(R.id.editTextPrenom);
        editTextId=(EditText)findViewById(R.id.editTextId);
        editTextNote= (EditText)findViewById(R.id.editTextNote);


        buttonViewUpdate= (Button)findViewById(R.id.btnSoumettre);
        buttonViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= myDb.getAllData();
                boolean isUpdate=myDb.updateData(editTextId.getText().toString(),editTextPrenom.getText().toString(),editTextNom.getText().toString(),editTextNote.getText().toString());
                if (isUpdate== true){
                    Toast.makeText(getApplicationContext(),"Mise a jour avec succes", Toast.LENGTH_LONG).show();
                }

                else{
                    Toast.makeText(getApplicationContext(),"Echec de la mise a jour ", Toast.LENGTH_LONG).show();
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("Prenom:"+res.getString(1)+"\n");
                    buffer.append("Nom :"+res.getString(2)+"\n");
                    buffer.append("Filiere :"+res.getString(3)+"\n");
                }
// Affichage des donnees recuperes
                AfficherMessage("Donnees",buffer.toString());
            }

        });

    }
    public void AfficherMessage(String titre, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();
    }



}
