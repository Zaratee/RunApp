package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ingresar, registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresar = (Button) findViewById(R.id.btn_ingMain);
        registrar = (Button) findViewById(R.id.btn_regMain);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentIng = new Intent(MainActivity.this,MenuApp.class);
                startActivity(intentIng);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this,RegistroApp.class);
                startActivity(intentReg);
            }
        });
    }
}
