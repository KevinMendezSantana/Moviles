package com.example.mendez26.a34_firebase_backend;

public class Item {
    private String nombre,control;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Item(String nombre, String control) {

        this.nombre = nombre;
        this.control = control;
    }
}
