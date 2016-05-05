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
        <link href="css/index.css" rel="stylesheet" type="text/css">
        <link href="js/jquery-ui-1.11.4.custom/jquery-ui.min.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js" type="text/javascript" ></script>
        <script src="js/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
        <script src="js/scripts.js" type="text/javascript" ></script>
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Usuarios Existentes</h1>
        <button id="create-user">Create new user</button>
        <br><br>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Password</th>
                    <th>Username</th>
                    <th>Direccion(s)</th>
                    <th>Permisos</th>
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
        <div id="dialog-form" title="Create new user">
            <p class="validateTips">All form fields are required.</p>
            <form>
                <fieldset>
                    <label for="name">Nomre</label>
                    <input type="text" name="nombre" id="nombre" value="" class="text ui-widget-content ui-corner-all">
                    <label for="email">Usuario</label>
                    <input type="text" name="username" id="username" value="" class="text ui-widget-content ui-corner-all">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
                    <!-- Allow form submission with keyboard without duplicating the dialog button -->
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>
    </body>
</html>
