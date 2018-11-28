package com.example.zarate.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
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

import java.util.regex.Pattern;

public class RegistroApp extends AppCompatActivity {

    Button Crear;
    EditText Correo, CorreoConf, Contra, ContraConfi;
    TextView prueba;

    String Cor,CorConf, Con,ConConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_app);
        Crear = (Button) findViewById(R.id.btn_crearReg);
        Correo = (EditText) findViewById(R.id.eTxt_correoReg);
        CorreoConf = (EditText) findViewById(R.id.eTxt_correoConfReg);
        Contra = (EditText) findViewById(R.id.eTxt_contraReg);
        ContraConfi = (EditText) findViewById(R.id.eTxt_contraConfReg);

        prueba = (TextView) findViewById(R.id.prueba3);

        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Corre1,Correo2,Contra1,Contra2;

                Corre1 = Correo.getText().toString();
                Correo2  = CorreoConf.getText().toString();
                Contra1 = Contra.getText().toString();
                Contra2 = ContraConfi.getText().toString();

                register();

                if(Corre1.equals(Correo2) && Contra1.equals(Contra2) && !Contra1.isEmpty() && !Contra2.isEmpty() && !Corre1.isEmpty() && !Correo2.isEmpty() )
                    prueba.setText("vamos");
                else
                    prueba.setText("nope");

            }
        });
    }

    public void register(){
        initialize();
        if (!validate()){
            Toast.makeText(this,"Registro fallido",Toast.LENGTH_SHORT).show();
        }else{
            onSignupSucces();
        }
    }

    private void onSignupSucces() {

        String url = "http://192.168.1.80:8081/runapp/crearusuario.php?reg="+ Correo.getText().toString()+"&cont="+ Contra.getText().toString();
        final Intent iniciarDocente = new Intent(RegistroApp.this,MainActivity.class);
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

                                        case "true":
                                            startActivity(iniciarDocente);
                                            Toast.makeText(RegistroApp.this,"Usuario Creado",Toast.LENGTH_SHORT).show();
                                            break;
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
                        Toast.makeText(RegistroApp.this,"Error usuario no creado",Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue x = Volley.newRequestQueue(RegistroApp.this);
        x.add(peticion);
        }




    public void initialize() {

        Cor = Correo.getText().toString().trim();
        CorConf = CorreoConf.getText().toString().trim();
        Con = Contra.getText().toString().trim();
        ConConf = ContraConfi.getText().toString().trim();
    }
    public boolean validate(){
        boolean valid = true;
        if(Cor.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(Cor).matches()){
            Correo.setError("Correo no valido");
            valid = false;
        }
         if(CorConf.isEmpty() || !CorConf.equals(Cor)){
            CorreoConf.setError("Correo no valido");
            valid = false;
         }

        if(Con.isEmpty() ){
            Contra.setError("Contraseña no valida");
            valid = false;
        }

        if(ConConf.isEmpty() || !ConConf.equals(Con) ){
            ContraConfi.setError("Contraseña no valida");
            valid = false;
        }

        return valid;
    }
}
