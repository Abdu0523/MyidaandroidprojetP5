
package com.ndiayeabdoundour@gmail.projet1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class insertion extends AppCompatActivity {

    DatabaseHelper myDb;
    Button button;
    Button buttonAfficher;
    Button buttonViewUpdate;
    Button buttonDelete;
    EditText editTextPrenom, editTextNom, editTextNote, editTextId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);
        myDb= new DatabaseHelper(this);
        editTextNom= (EditText)findViewById(R.id.editTextNom);
        editTextPrenom=(EditText)findViewById(R.id.editTextPrenom);
        editTextId=(EditText)findViewById(R.id.editTextId);
        editTextNote = (EditText) findViewById(R.id.editTextNote);


        buttonViewUpdate = (Button) findViewById(R.id.btnSoumettre);
        buttonViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Cursor res= myDb.getAllData();
            boolean isInserted = myDb.insertData(editTextPrenom.getText().toString(), editTextNom.getText().toString(), editTextNote.getText().toString()
            );
            if(isInserted==true){
                Toast.makeText(getApplicationContext(),"Insertion des donnees avec avec succes",Toast.LENGTH_LONG).show();
            }

            else{
                Toast.makeText(getApplicationContext(),"Echec de l'insertion des donnees", Toast.LENGTH_LONG).show();
            }


            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Prenom\t Nom\t filière\t id");
                buffer.append(res.getString(0)+"\t");
                buffer.append(res.getString(1)+"\t");
                buffer.append(res.getString(2)+"\t");
                buffer.append(res.getString(3)+"\t");
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
