<%@ page language="java" import="java.util.List, java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>
<%!
List<String> errors;
%>
<% List<String> errors = (List<String>)request.getAttribute("es.brunomendoza.dsw.att.errors"); %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
    <div class="wrapper">
        <form action="/" class="form" method="post">
            <fieldset>
                <div class="control-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
                    <span class="error <%= errors != null && errors.contains("username") ? "" : "hidden" %>">Nombre de usuario requerido</span>
                </div>
                <div class="control-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                    <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
                </div>
                <button class="primary-button">Enviar</button>
            </fieldset>
        </form>
        <span class="error <%= errors != null && errors.contains("authentication") ? "" : "hidden" %>">Usuario o contraseña no válido</span>
        <span class="error <%= errors != null && errors.contains("system") ? "" : "hidden" %>">Error de sistema</span>
        <span class="error <%= errors != null && errors.contains("not_found") ? "" : "hidden" %>">Usuario no encontrado</span>
    </div>
</body>
</html>