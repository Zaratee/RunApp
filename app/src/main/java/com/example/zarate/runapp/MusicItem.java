package com.example.zarate.runapp;

public class MusicItem  {
    private String nombre;
    private String singer;
    private int cancion;

    public MusicItem(String nombre, String singer, int cancion) {
        this.nombre = nombre;
        this.singer = singer;
        this.cancion = cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getCancion() {
        return cancion;
    }

    public void setCancion(int cancion) {
        this.cancion = cancion;
    }
}
