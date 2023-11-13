package com.ndiayeabdoundour@gmail.projet1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        accueil();
        inserer();
        modifier();
        supprimer();

    }

    private void accueil() {
        ((Button)findViewById(R.id.affiche)).setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(accueil.this, affichage.class);
                        startActivity(intent);

                    }
                });


    }
    private void inserer() {
        ((Button)findViewById(R.id.ins)).setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(accueil.this, insertion.class);
                        startActivity(intent);

                    }
                });


    }

    private void modifier() {
        ((Button)findViewById(R.id.modif)).setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(accueil.this, modifier.class);
                        startActivity(intent);

                    }
                });


    }

    private void supprimer() {
        ((Button)findViewById(R.id.supp)).setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(accueil.this, supprimer.class);
                        startActivity(intent);

                    }
                });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
