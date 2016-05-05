package com.db;

public class Direcciones {
    private int id;
    private String calle;
    private String codigoPostal;

    public int getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Direcciones(int id, String calle, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
    }

    public Direcciones() {
    }
}
