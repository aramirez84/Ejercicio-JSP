/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

/**
 *
 * @author alejandro.ramirez
 */
public class Usuario {
    // Tabla usuarios
    int id;
    String nombre;
    String password;
    String username;
    
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
