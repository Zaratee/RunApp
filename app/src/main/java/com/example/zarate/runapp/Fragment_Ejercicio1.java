package com.example.zarate.runapp;

import android.os.Bundle;
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
    TextView pasostxt;
    Chronometer crono;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ejercicio_app,container,false);

        start = (Button) v.findViewById(R.id.btnStart_fragmentEje1);
        stop = (Button) v.findViewById(R.id.btnStop_fragmentEje1);
        pause = (Button) v.findViewById(R.id.btnStop_fragmentEje1);

        pasostxt = (TextView) v.findViewById(R.id.txtV_pasosfragmentEje1);
        crono = (Chronometer) v.findViewById(R.id.chro_fragmentEje1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crono.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crono.stop();
            }
        });


        return v;
    }
}
