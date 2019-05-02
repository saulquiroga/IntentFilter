package com.example.usuario.intentfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class Compartir extends AppCompatActivity {

    EditText compartirtext;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartir);

        compartirtext=findViewById(R.id.textoCompartir);
        // de donde se ah iniciado la actividad
        Intent intent=getIntent();
        String action=intent.getAction();
        String type=intent.getType();


        if (Intent.ACTION_SEND.equals(action)&& type!=null){

            if (type.equals("text/plain")){
                Bundle bundle = intent.getExtras();
                String txt=bundle.getString(Intent.EXTRA_TEXT);
                compartirtext.setText(txt);
            }
        }

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.borrar:
                Toast.makeText(this, "Menu Borrar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(this, "Menu añadir", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fav:
                Toast.makeText(this, "Agregado a Favoritos", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "Atras", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
