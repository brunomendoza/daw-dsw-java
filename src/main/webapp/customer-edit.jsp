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
  <div class="wrapper">
    <h2>Customer</h2>
  </div>
  <script src="./js/jquery-3.6.0.js"></script>
</body>
</html>