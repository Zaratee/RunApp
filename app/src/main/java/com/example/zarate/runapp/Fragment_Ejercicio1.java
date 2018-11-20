package com.example.zarate.runapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Fragment_Ejercicio1 extends Fragment {

    Button start,stop,pause;
    TextView pasostxt,prueb1,prueb2;
    Chronometer crono;
    boolean iniciado,point=false;
    long tiempo;
    int i=0,bandera1=0,bandera2=0,delay=1000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ejercicio_app, container, false);

        start = (Button) v.findViewById(R.id.btnStart_fragmentEje1);
        stop = (Button) v.findViewById(R.id.btnStop_fragmentEje1);
        pause = (Button) v.findViewById(R.id.btnPause_fragmentEje1);

        pasostxt = (TextView) v.findViewById(R.id.txtV_pasosfragmentEje1);
        crono = (Chronometer) v.findViewById(R.id.chro_fragmentEje1);

        prueb1=(TextView) v.findViewById(R.id.prueba1);
        prueb2=(TextView) v.findViewById(R.id.prueba2);

        start.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(false);

/*        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(false);
                pause.setEnabled(true);
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(true);
                pause.setEnabled(false);
                crono.stop();
            }
        });*/
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCrono();
                start.setEnabled(false);
                pause.setEnabled(true);
                stop.setEnabled(true);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseCrono();
                start.setEnabled(true);
                pause.setEnabled(false);
                stop.setEnabled(true);
                start.setText("Resume");
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopCrono();
                start.setEnabled(true);
                pause.setEnabled(false);
                stop.setEnabled(false);
                start.setText("Start");

            }
        });


        return v;
    }
    void incremento(){
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                i++;
                i=bandera1;
                pasostxt.setText(""+i);
                incremento2();

            }
        }, delay);
    }

    void incremento2(){
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                i=bandera1;
                i++;
                pasostxt.setText(""+i);
                incremento();

            }
        }, delay);
    }


    public void startCrono()
    {
            incremento();
            crono.setBase(SystemClock.elapsedRealtime() - tiempo);
            crono.start();
            iniciado=true;

    }

    public void pauseCrono()
    {
        if (iniciado) {
            crono.stop();
            tiempo = SystemClock.elapsedRealtime() - crono.getBase();
            iniciado=false;
        }
    }

    public void stopCrono()
    {
        crono.setBase(SystemClock.elapsedRealtime());
        tiempo = 0;
    }


}
