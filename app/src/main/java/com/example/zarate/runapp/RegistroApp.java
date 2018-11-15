package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroApp extends AppCompatActivity {

    Button Crear;
    EditText Correo, CorreoConf, Contra, ContraConfi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_app);
        Crear = (Button) findViewById(R.id.btn_crearReg);
        Correo = (EditText) findViewById(R.id.eTxt_correoReg);
        CorreoConf = (EditText) findViewById(R.id.eTxt_correoConfReg);
        Contra = (EditText) findViewById(R.id.eTxt_contraReg);
        ContraConfi = (EditText) findViewById(R.id.eTxt_contraConfReg);

        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crearIntent = new Intent(RegistroApp.this,MainActivity.class);
                startActivity(crearIntent);
            }
        });
    }
}
