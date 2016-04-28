/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;
import com.db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.db.Usuario;
import java.sql.SQLException;
import java.util.LinkedList;
/**
 *
 * @author alejandro.ramirez
 */
public class Operaciones {
    static int id;
    public static int getUltimoID(){
        try
        {
            Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT id FROM usuarios ORDER BY id DESC LIMIT 1");
                rs.next();
                id=rs.getInt(1);
                System.out.println(id);
                st.close();
                rs.close();
            }
            d.cerrarConexion();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static boolean insertUsuario(Usuario usuario)
    {
        boolean agregado=false;
        try
        {
            Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                st=con.createStatement();
                st.executeUpdate("INSERT INTO usuarios (id,nombre,password,username) VALUES ('"+usuario.getId()+"','"+usuario.getNombre()+"','"+usuario.getPassword()+"','"+usuario.getUsername()+"')");
                agregado=true;
                st.close();
            }
            d.cerrarConexion();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return agregado;
    }
    
    public static LinkedList<Usuario> getUsuarios(){
        LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
        try{
         Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                st=con.createStatement();
                st.executeUpdate("INSERT INTO usuarios (id,nombre,password,username) VALUES ('"+usuario.getId()+"','"+usuario.getNombre()+"','"+usuario.getPassword()+"','"+usuario.getUsername()+"')");
                agregado=true;
                st.close();
            }
            d.cerrarConexion();   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    
}
