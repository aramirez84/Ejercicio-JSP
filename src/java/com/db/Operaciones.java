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
import java.util.ArrayList;
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
    
    public static int getUltimoIDDireccion(){
        try
        {
            Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT id FROM direcciones ORDER BY id DESC LIMIT 1");
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
    
    public static int getUltimoIDPermisos(){
        try
        {
            Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT id FROM permisos ORDER BY id DESC LIMIT 1");
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
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT * FROM usuarios");
                while(rs.next())
                {
                    Usuario usuario= new Usuario();
                    usuario.setId(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setPassword(rs.getString(3));
                    usuario.setUsername(rs.getString(4));
                    listaUsuarios.add(usuario);
                }
                rs.close();
                st.close();
            }
            d.cerrarConexion();   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    
    public static LinkedList<Permisos> getPermisos(){
        LinkedList<Permisos> listaPermisos = new LinkedList<Permisos>();
        try{
         Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT * FROM permisos");
                while(rs.next())
                {
                    Permisos permisos= new Permisos();
                    permisos.setId(rs.getInt(1));
                    permisos.setEstatus(rs.getInt(2));
                    permisos.setNombre(rs.getString(3));
                    listaPermisos.add(permisos);
                }
                rs.close();
                st.close();
            }
            d.cerrarConexion();   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaPermisos;
    }
    
    public static LinkedList<Permisos> getPermisosUsuario(){
        LinkedList<Permisos> listaPermisosUsuario = new LinkedList<Permisos>();
        try{
         Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT u.id as userID,u.nombre as nombreUsuario,username,p.id as permisoID,estatus,p.nombre as nombrePermiso FROM usuarios u INNER JOIN usuarios_permisos up ON u.id=up.usuarios_id INNER JOIN permisos p on up.permisos_id=p.id ");
                while(rs.next())
                {
                    Permisos permisos= new Permisos();
                    permisos.setId(rs.getInt(1));
                    permisos.setEstatus(rs.getInt(2));
                    permisos.setNombre(rs.getString(3));
                    listaPermisosUsuario.add(permisos);
                }
                rs.close();
                st.close();
            }
            d.cerrarConexion();   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaPermisosUsuario;
    }
    
    public static LinkedList<Direcciones> getDirecciones(){
        LinkedList<Direcciones> listaDirecciones = new LinkedList<Direcciones>();
        try{
         Database d= new Database();
            Connection con=d.getConection();
            if(con!=null)
            {
                Statement st;
                ResultSet rs;
                st=con.createStatement();
                rs=st.executeQuery("SELECT * FROM direcciones");
                while(rs.next())
                {
                    Direcciones direcciones= new Direcciones();
                    direcciones.setId(rs.getInt(1));
                    direcciones.setCalle(rs.getString(2));
                    direcciones.setCodigoPostal(rs.getString(3));
                    listaDirecciones.add(direcciones);
                }
                rs.close();
                st.close();
            }
            d.cerrarConexion();   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaDirecciones;
    }
}
