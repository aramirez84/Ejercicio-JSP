<%-- 
    Document   : AgregarUsuario
    Created on : 26/04/2016, 09:01:03 PM
    Author     : alejandro.ramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletAgregar" method="POST">
            <label>Nombre:</label>
            <input type="text" name="nombre" value="" />
            <label>Usuario:</label>
            <input type="text" name="username" value="" />
            <label>Password</label>
            <input type="password" name="password" value="" />
            <input type="submit" value="Agregar" />
        </form>
    </body>
</html>