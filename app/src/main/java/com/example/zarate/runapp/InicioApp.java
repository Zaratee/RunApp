package com.example.zarate.runapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class InicioApp extends AppCompatActivity {

    private GifImageView gifRay,gifBack;
    private ProgressBar pbar;
    int posicion = 0;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_app);

        gifRay = (GifImageView) findViewById(R.id.gif_raymanInicio);
        gifBack = (GifImageView) findViewById(R.id.gif_paisajeInicio);
        pbar = (ProgressBar) findViewById(R.id.prgrsBar_inicio);

        pbar.setVisibility(View.VISIBLE);
        mp = MediaPlayer.create(this,R.raw.intro);
        mp.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                InicioApp.this.startActivity(new Intent(InicioApp.this, MainActivity.class));
                InicioApp.this.finish();
            }
        },7500);
    }
}
