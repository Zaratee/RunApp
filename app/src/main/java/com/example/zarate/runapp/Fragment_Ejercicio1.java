package com.example.zarate.runapp;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Fragment_Ejercicio1 extends Fragment implements SensorEventListener{

    Button start,stop,pause;
    TextView cronometro,prueb1,prueb2,pasos;
    boolean iniciado,point=false;

    private static final long Start_time = 1800000;
    private CountDownTimer mCountDown;
    private boolean mTimerRun;

    private long mTimeLeft = Start_time;

    SensorManager sensorManager;
    boolean running = false;

    private ArrayList<MusicItem> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ejercicio_app, container, false);

        songlist = (ListView) v.findViewById(R.id.listVmusica_fragmentEje1);
        arrayList = new ArrayList<>();
        arrayList.add(new MusicItem("","",R.raw.intro));
        arrayList.add(new MusicItem("","",R.raw.fate));
        arrayList.add(new MusicItem("","",R.raw.flow));
        arrayList.add(new MusicItem("","",R.raw.phantomGate));
        /*
        arrayList.add(new MusicItem("","",R.raw.));
        arrayList.add(new MusicItem("","",R.raw.));
        arrayList.add(new MusicItem("","",R.raw.));
        arrayList.add(new MusicItem("","",R.raw.));
        */


        start = (Button) v.findViewById(R.id.btnStart_fragmentEje1);
        stop = (Button) v.findViewById(R.id.btnStop_fragmentEje1);
        pause = (Button) v.findViewById(R.id.btnPause_fragmentEje1);

        cronometro = (TextView) v.findViewById(R.id.txtV_cronometro);

        prueb1=(TextView) v.findViewById(R.id.prueba1);
        prueb2=(TextView) v.findViewById(R.id.prueba2);
        pasos = (TextView) v.findViewById(R.id.txtV_pasos);

        start.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(false);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
                running = true;
                Sensor countS = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                if(countS != null) {
                    sensorManager.registerListener(Fragment_Ejercicio1.this,countS,SensorManager.SENSOR_DELAY_UI);//posible error cambiar act
                }else {
                    Activity activity = getActivity();
                    Toast.makeText(activity,"Sensor no encontrado",Toast.LENGTH_SHORT).show();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseTimer();
                running = false;
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
            }
        });

        updateCountDownText();

        sensorManager  = (SensorManager)this.getActivity().getSystemService(EjercicioActi1.SENSOR_SERVICE);
        return v;
    }



    private void startTimer(){
        mCountDown = new CountDownTimer(mTimeLeft,1000) {
            @Override
            public void onTick(long a) {
                mTimeLeft = a;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRun = false;
                start.setEnabled(true);
                pause.setEnabled(false);
                stop.setEnabled(false);
            }
        }.start();

        mTimerRun = true;
        start.setEnabled(false);
        pause.setEnabled(true);
        stop.setEnabled(true);
    }


    private void pauseTimer(){
        mCountDown.cancel();
        mTimerRun = false;

        start.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(true);

    }

    private void stopTimer(){
        mTimeLeft = Start_time;
        updateCountDownText();


        start.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(false);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeft /1000) /60;
        int seconds = (int) (mTimeLeft /1000) %60;
        int totalSeg=0, totalMin=0;
        totalSeg = 60-seconds;
        totalMin = 29-minutes;
        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        prueb1.setText(""+totalMin);
        prueb2.setText(""+totalSeg);
        cronometro.setText(timeFormatted);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        pasos.setText(String.valueOf(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
