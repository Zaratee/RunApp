package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Button ingresar, registrar;
    EditText correo, contraseña;
    public static String Correo = "Caros";
    public static String Pasos  = "Caros";
    public static String Minutos = "Caros";
    public static String Segundos = "Caros";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresar = (Button) findViewById(R.id.btn_ingMain);
        registrar = (Button) findViewById(R.id.btn_regMain);
        correo = (EditText) findViewById(R.id.eTxt_correoMain);
        contraseña = (EditText) findViewById(R.id.eTxt_contraMain);

         TextView prueba = (TextView) findViewById(R.id.pruebaaa);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.1.80:8081/runapp/loginuser.php?usu="+ correo.getText().toString()+"&cont="+contraseña.getText().toString();
                final Intent iniciarAdmin = new Intent(MainActivity.this,MenuApp.class);
                JsonObjectRequest peticion = new JsonObjectRequest
                        (
                                Request.Method.GET,
                                url,
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            String valor = response.getString("Estado");
                                            switch(valor) {
                                                case "OK":
                                                    String corr;
                                                    corr = correo.getText().toString();
                                                    Correo= corr;
                                                    iniciarAdmin.putExtra("correo",corr );
                                                    startActivity(iniciarAdmin);
                                                    break;
                                                case "NO":
                                                    Toast.makeText(MainActivity.this,"Usuario no existe",Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                , new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(MainActivity.this,"Error php",Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(MainActivity.this);
                x.add(peticion);
            }

        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this,RegistroApp.class);
                startActivity(intentReg);
                Toast.makeText(MainActivity.this,"Completar los campos",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
