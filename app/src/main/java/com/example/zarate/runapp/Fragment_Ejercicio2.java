package com.example.zarate.runapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.zarate.runapp.MainActivity.Minutos;
import static com.example.zarate.runapp.MainActivity.Pasos;
import static com.example.zarate.runapp.MainActivity.Segundos;


public class Fragment_Ejercicio2 extends Fragment {

    TextView fecha, pas, min,seg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ejercicio_app, container, false);
        fecha = (TextView) v.findViewById(R.id.txtV_fechaEje2);
        pas = (TextView) v.findViewById(R.id.txtV_numPasos);
        min = (TextView) v.findViewById(R.id.txtV_Minutos);
        seg = (TextView) v.findViewById(R.id.txtV_Segundos);

        pas.setText(Pasos);
        min.setText(Minutos);
        seg.setText(Segundos);

        return v;
    }
}
