package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuApp extends AppCompatActivity {

    Button Ejercicio, Alimentacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        Ejercicio = (Button) findViewById(R.id.btn_ejerMenu);
        Alimentacion = (Button) findViewById(R.id.btn_alimMenu);

        Ejercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ejerIntet = new Intent(MenuApp.this,EjercicioActi1.class);
                startActivity(ejerIntet);
            }
        });

        Alimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alimIntet = new Intent(MenuApp.this,AlimentacionApp.class);
                startActivity(alimIntet);
            }
        });
    }
}
