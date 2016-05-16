/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author alejandro.ramirez
 */
public class Database{
    private static String servidor="jdbc:mysql://localhost/bdexamen";
    private static String user="examen";
    private static String pass="exa829";
    private static String driver="com.mysql.jdbc.Driver";
    private static Connection conexion;
    private static String mensaje;
    
    public Database(){
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(servidor,user,pass);
            System.out.println("Conexion realizada con exito");
        } 
        catch (ClassNotFoundException | SQLException e) {
            setMensaje(e.getMessage());
            System.out.println("Mensaje: "+e.getMessage());
        }
    }
    
    public Connection getConection(){
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            if(conexion!=null)
            {
                conexion.close();
                System.out.println("Cerrando conexion");                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getMensaje()
    {
        return mensaje;
    }
    
    public void setMensaje(String mensaje){
        mensaje=mensaje;
    }
}
