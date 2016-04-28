<%-- 
    Document   : index
    Created on : 25/04/2016, 11:17:16 PM
    Author     : alejandro.ramirez
--%>

<%@page import="com.db.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.db.Operaciones" %>
<%@page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Usuarios Existentes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Password</th>
                    <th>Username</th>    
                </tr>
            </thead>
            <tbody>
            <%
                LinkedList<Usuario> usuarios=Operaciones.getUsuarios();
                for(int i=0;i<usuarios.size();i++)
                {
                    out.println("<tr>");
                    out.println("<td>"+usuarios.get(i).getNombre()+"</td>");
                    out.println("<td>"+usuarios.get(i).getPassword()+"</td>");
                    out.println("<td>"+usuarios.get(i).getUsername()+"</td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>
    </body>
</html>
