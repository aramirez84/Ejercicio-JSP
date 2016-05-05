package com.db;

/**
 *
 * @author alejandro.ramirez
 */
public class Usuario {
    // Tabla usuarios
    private int id;
    private String nombre;
    private String password;
    private String username;
    
    public Usuario()
    {
        
    }
    public Usuario(int id,String nombre, String password, String username) {
        super();
        this.id=id;
        this.nombre = nombre;
        this.password = password;
        this.username = username;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    } 
}
