package com.debug.prueba.aplicacion.juanpedrog.laboratorio223;

/**
 * Created by juanpedrog on 5/03/18.
 */

public class Datos {
    private String clave;
    private String nombre;
    private String salario;

    public Datos(String clave,String nombre,String salario) {
        this.clave = clave;
        this.nombre=nombre;
        this.salario=salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {

        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
