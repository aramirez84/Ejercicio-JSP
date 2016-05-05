package com.db;

/**
 *
 * @author alejandro.ramirez
 */
public class Permisos {
    private int id;
    private int estatus;
    private String nombre;

    public int getId() {
        return id;
    }

    public int getEstatus() {
        return estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permisos() {
    }

    public Permisos(int id, int estatus, String nombre) {
        this.id = id;
        this.estatus = estatus;
        this.nombre = nombre;
    }
    
}
