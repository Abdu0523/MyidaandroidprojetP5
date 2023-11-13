package com.ndiayeabdoundour@gmail.projet1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button login;
    SharedPreferences SharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)findViewById(R.id.txtuser);
        pass = (EditText)findViewById(R.id.txtpass);
        login = (Button)findViewById(R.id.btnSoumettre);
        SharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        savelogincheckbox = (CheckBox)findViewById(R.id.checkbox);
        editor = SharedPreferences.edit();
        affiche();
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                login();


            }
        });
        savelogin=SharedPreferences.getBoolean("savelogin",true);

        if(savelogin==true){
            user.setText(SharedPreferences.getString("username",null));
            pass.setText(SharedPreferences.getString("password",null));

        }


    }

    private void affiche() {
    }

    public void login(){
        String usrname = user.getText().toString();
        String passwrd = pass.getText().toString();
        if(usrname.equals("admin") && passwrd.equals("admin")){
                ((Button)findViewById(R.id.btnSoumettre)).setOnClickListener(
                        new Button.OnClickListener(){

                            public void  onClick(View v){
                                Intent intent = new Intent(MainActivity.this, accueil.class);
                                startActivity(intent);

                            }
                        });

        }else{
            Toast.makeText(this,"Login ou mot de passe incorrecte",Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
