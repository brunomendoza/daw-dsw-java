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
  <link rel="stylesheet" href="./css/style.css" />
  <link rel="stylesheet" href="./css/jquery-ui.css" />
  <link rel="stylesheet" href="./css/jquery-ui.structure.css" />
  <link rel="stylesheet" href="./css/jquery-ui.theme.css" />
  <title>Document</title>
</head>
<body>
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
    <a id="customer-update-button" href="/customer/update">Edit</a>
  </div>
  <script src="./js/jquery.js"></script>
  <script src="./js/jquery-ui.js"></script>
  <script src="./js/script.js"></script>
</body>
</html>