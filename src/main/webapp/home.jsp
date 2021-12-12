<%@ page import="java.util.List, java.util.ArrayList" %>
<%!
List<String> errors = new ArrayList<>();
out.println(request.getAttribute("es.brunomendoza.dsw.errors"));
%>
<!doctype html>
<html lang="en">
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
                    <input type="text" name="username" id="username">
                    <span class=".error <%= errors.contains("username") ? out.print("") : out.print("hidden"); %>">Nombre de usuario requerido</span>
                </div>
                <div class="control-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                </div>
                <button class="primary-button">Enviar</button>
            </fieldset>
        </form>
    </div>
</body>
</html>