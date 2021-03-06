<%-- 
    Document   : index
    Created on : 25/04/2016, 11:17:16 PM
    Author     : alejandro.ramirez
--%>

<%@page import="com.db.Usuario"%>
<%@page import="com.db.Permisos"%>
<%@page import="com.db.Direcciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.db.Operaciones" %>
<%@page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
        <link href="css/index.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js" type="text/javascript" ></script>
        <script src="js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript" ></script>
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Usuarios Existentes</h1>
        <button id="create-user"></button>
        <br><br>
        <%
            LinkedList<Usuario> usuarios = Operaciones.getUsuarios();
            LinkedList<Permisos> permisosUsuario = Operaciones.getPermisosUsuario();
            LinkedList<Direcciones> direccionesUsuario = Operaciones.getDirecciones();
            if (usuarios.size() == 1 && usuarios.get(0).getUsername()== null ) {
                String dialog = "<div id='dialog-message'title='Error'>"
                    + " <p>"
                    + " <span class='ui-icon ui-icon-alert ' style='float:left; margin:0 7px 50px 0;'></span>"
                    + " Hubo un error con la base de datos. "
                    + "</p> <p> ERROR:  <b> "+usuarios.get(0).getNombre()+" </b>. </p> </div>";
                out.println(dialog);
            }

        %>
        <table border="1">
            <thead>
                <tr>
                    <th> # </th>
                    <th>Nombre</th>
                    <th>Password</th>
                    <th>Username</th>
                    <th colspan="2">Permisos</th>
                    <th colspan="2">Direccion(es)</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (usuarios.size() == 0 || usuarios.get(0).getUsername()== null) {
                        out.println("<tr>");
                        out.println("<td colspan='8'>No hay usuarios registrados</td>");
                        out.println("<tr>");
                    } else{
                        for (int i = 0; i < usuarios.size(); i++) {
                            out.println("<tr>");
                            out.println("<td>" + (i + 1) + "<input type='hidden' name='" + usuarios.get(i).getNombre() + "' value='" + usuarios.get(i).getId() + "' id='" + usuarios.get(i).getId() + "'></td>");
                            out.println("<td>" + usuarios.get(i).getNombre() + "</td>");
                            out.println("<td>" + usuarios.get(i).getPassword() + "</td>");
                            out.println("<td>" + usuarios.get(i).getUsername() + "</td>");
                            if (permisosUsuario.size() == 0) {
                                out.println("<td>No tiene permisos</td>");
                                out.println("<td><button class='btn-agregar-permisos'></button></td>");
                            } else {
                                out.println("<td></td>");
                                out.println("<td><button class='btn-quitar-permisos'></button><button class='btn-editar-permisos'></button></td>");
                            }
                            if (direccionesUsuario.size() == 0) {
                                out.println("<td> No tiene direecion(es)</td>");
                                out.println("<td><button class='btn-agregar-direccion'></button></td>");
                            } else {
                                out.println("<td></td>");
                                out.println("<td><button class='btn-quitar-direccion'></button><button class='btn-editar-direccion'></button></td>");
                            }
                            out.println("</tr>");
                        }
                    }
                %>
            </tbody>
        </table>
        <div id="dialog-form" title="Nuevo Usuario">
            <p class="validateTips">Todo los campos son requeridos.</p>
            <form>
                <fieldset>
                    <label for="name">Nomre</label>
                    <input type="text" name="nombre" id="nombre" value="" class="text ui-widget-content ui-corner-all">
                    <label for="email">Usuario</label>
                    <input type="text" name="username" id="username" value="" class="text ui-widget-content ui-corner-all">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>

        <div id="dialog-permisos" title="Permisos">
            <p class="validateTips">Seleccione los permisos.</p>
            <form>
                <fieldset>
                    <div id="format">
                        <%
                            LinkedList<Permisos> permisos = Operaciones.getPermisos();
                            if(permisos.size()!=0)
                            {
                                for (int i = 0; i < permisos.size(); i++) {
                                out.println("<input type='checkbox' name='permisos' value='" + permisos.get(i).getId() + "' id='permiso" + permisos.get(i).getId() + "' class='text'><label for='permiso" + permisos.get(i).getId() + "'>" + permisos.get(i).getNombre() + "</label><br>");
                                }
                            }
                            else
                            {
                                out.println("<div style='padding: 0 .7em;' class='ui-state-error ui-corner-all'>"
                                        +" <p><span style='float: left; margin-right: .3em;' class='ui-icon ui-icon-alert'></span>"
                                        +" <strong>Alert:</strong> No hay permisos en la Base de datos.</p>"
                                        +" </div>");
                            }
                        %>
                    </div>
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>
        <div id="dialog-direccion" title="Nueva Direccion">
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
