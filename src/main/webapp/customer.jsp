<%@ page language="java" import="es.brunomendoza.dsw.dto.CustomerDto" %>
<%@ page pageEncoding="UTF-8" %>
<% CustomerDto customer = (CustomerDto)request.getAttribute("es.brunomendoza.dsw.att.customer"); %>

<!doctype html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
  <div id="dialog-form" title="Editar cliente">
    <p class="validateTips"></p>
    <form action="/" class="form" method="post">
        <fieldset>
            <legend>Credenciales</legend>
            <div class="control-group">
                <label for="username">Usuario</label>
                <input type="text" name="username" id="username" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
                <span class="error <%= errors != null && errors.contains("username") ? "" : "hidden" %>">Nombre de usuario requerido</span>
            </div>
            <div class="control-group">
                <label for="username">Password</label>
                <input type="text" name="password" id="password" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
                <span class="error <%= errors != null && errors.contains("username") ? "" : "hidden" %>">Nombre de usuario requerido</span>
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos personales</legend>
            <div class="control-group">
                <label for="first-name">Nombre</label>
                <input type="text" name="firstName" id="first-name" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
                <span class="error <%= errors != null && errors.contains("username") ? "" : "hidden" %>">Nombre de usuario requerido</span>
            </div>
            <div class="control-group">
                <label for="last-name">Apellidos</label>
                <input type="text" name="lastName" id="last-name" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="birthdate">Fecha Nacimiento</label>
                <input type="text" name="birthdate" id="birthdate" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="address">Dirección</label>
                <input type="text" name="address" id="address" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="phone-number1">Teléfono 1</label>
                <input type="text" name="phoneNumber1" id="phone-number1" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="phone-number2">Teléfono 2</label>
                <input type="text" name="phoneNumber2" id="phone-number2" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="country">Apellidos</label>
                <input type="text" name="country" id="country" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <div class="control-group">
                <label for="email">E-mail</label>
                <input type="text" name="email" id="email" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
                <span class="error <%= errors != null && errors.contains("password") ? "" : "hidden" %>">Password requerido</span>
            </div>
            <button class="primary-button">Enviar</button>
        </fieldset>
    </form>
    <span class="error <%= errors != null && errors.contains("authentication") ? "" : "hidden" %>">Usuario o contraseña no válido</span>
    <span class="error <%= errors != null && errors.contains("system") ? "" : "hidden" %>">Error de sistema</span>
    <span class="error <%= errors != null && errors.contains("not_found") ? "" : "hidden" %>">Usuario no encontrado</span>
  </div>
  <div class="wrapper">
    <h2>Customer</h2>
    <table>
      <tr>
        <th>Nombre</th>
        <td><%= customer.getFirstName() %></td>
      <tr>
      <tr>
        <th>Apellidos</th>
        <td><%= customer.getLastName() %></td>
      <tr>
      <tr>
        <th>Fecha Nacimiento</th>
        <td><%= customer.getBirthdate() %></td>
      <tr>
      <tr>
        <th>Dirección</th>
        <td><%= customer.getAddress() %></td>
      <tr>
      <tr>
        <th>Teléfono 1</th>
        <td><%= customer.getPhoneNumber1() %></td>
      <tr>
      <tr>
        <th>Teléfono 2</th>
        <td><%= customer.getPhoneNumber2() == null ? "Ninguno" : customer.getPhoneNumber2() %></td>
      <tr>
      <tr>
        <th>País</th>
        <td><%= customer.getCountry() %></td>
      <tr>
      <tr>
        <th>Nombre</th>
        <td><%= customer.getFirstName() %></td>
      <tr>
    </table>
    <a href="/customer/edit">Edit</a>
  </div>
</body>
</html>