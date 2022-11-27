package com.app.segundapruebaapp;

import java.io.Serializable;

public class Tarea implements Serializable {
    private int id;
    private String titulo;
    private String descripcion;

    public String toString(){
        return titulo + "---"+ descripcion;
    }

    public Tarea() {
    }

    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Tarea(int id, String titulo, String descripcion) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
