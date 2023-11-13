package com.ndiayeabdoundour@gmail.projet1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class supprimer extends AppCompatActivity {

    DatabaseHelper myDb;

    Button buttonDelete;
    EditText editTextPrenom, editTextNom, editTextNote, editTextId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        myDb = new DatabaseHelper(this);
        editTextNom = (EditText) findViewById(R.id.editTextNom);
        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextNote = (EditText) findViewById(R.id.editTextNote);

        buttonDelete = (Button) findViewById(R.id.btnDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
                if (deleteRows > 0)
                    Toast.makeText(getApplicationContext(), "Suppression avec succes", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Echec de la suppression ", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void AfficherMessage(String titre, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();
    }

}


