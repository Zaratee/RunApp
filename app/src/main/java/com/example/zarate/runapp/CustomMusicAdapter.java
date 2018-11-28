package com.example.zarate.runapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MusicItem> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    public CustomMusicAdapter(Context context, int layout, ArrayList<MusicItem> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtNombre, txtArtista;
        ImageView icPlay, icStop;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);

            viewHolder.txtNombre = (TextView) view.findViewById(R.id.txtVnombreCancion_item);
            viewHolder.txtArtista = (TextView) view.findViewById(R.id.txtVnombreArtista_item);
            viewHolder.icPlay = (ImageView) view.findViewById(R.id.playicon);
            viewHolder.icStop = (ImageView) view.findViewById(R.id.stopicon);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final MusicItem music = arrayList.get(i);
        viewHolder.txtNombre.setText(music.getNombre());
        viewHolder.txtArtista.setText(music.getSinger());

        viewHolder.icPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    mediaPlayer = MediaPlayer.create(context,music.getCancion());
                    flag=false;
                }
                if(mediaPlayer.isPlaying()) 
                        {
                            mediaPlayer.pause();
                            viewHolder.icPlay.setImageResource(R.drawable.playicon);
                        }else{
                    mediaPlayer.start();
                    viewHolder.icPlay.setImageResource(R.drawable.playicon);
                }

            }
        });
        viewHolder.icStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.icPlay.setImageResource(R.drawable.playicon);
            }
        });
        return view;
    }
}
