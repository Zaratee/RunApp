package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuApp extends AppCompatActivity {

    Button Ejercicio, Alimentacion;
    TextView pruebCorreo;
    String corrrr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        Ejercicio = (Button) findViewById(R.id.btn_ejerMenu);
        Alimentacion = (Button) findViewById(R.id.btn_alimMenu);
        pruebCorreo = (TextView) findViewById(R.id.correoprueba);

        pruebCorreo.setText(MainActivity.Correo);


        Ejercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ejerIntet = new Intent(MenuApp.this,EjercicioActi1.class);
                ejerIntet.putExtra("corre",corrrr );
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
