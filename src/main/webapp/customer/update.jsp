<div id="dialog-form" title="Editar cliente">
    <p class="validateTips"></p>
    <form action="/" class="form" method="post">
        <fieldset>
            <legend>Credenciales</legend>
            <div class="control-group">
                <label for="username">Usuario</label>
                <input type="text" name="username" id="username" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
            </div>
            <div class="control-group">
                <label for="username">Password</label>
                <input type="text" name="password" id="password" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos personales</legend>
            <div class="control-group">
                <label for="first-name">Nombre</label>
                <input type="text" name="firstName" id="first-name" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>">
            </div>
            <div class="control-group">
                <label for="last-name">Apellidos</label>
                <input type="text" name="lastName" id="last-name" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="birthdate">Fecha Nacimiento</label>
                <input type="text" name="birthdate" id="birthdate" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="address">Dirección</label>
                <input type="text" name="address" id="address" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="phone-number1">Teléfono 1</label>
                <input type="text" name="phoneNumber1" id="phone-number1" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="phone-number2">Teléfono 2</label>
                <input type="text" name="phoneNumber2" id="phone-number2" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="country">Apellidos</label>
                <input type="text" name="country" id="country" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <div class="control-group">
                <label for="email">E-mail</label>
                <input type="text" name="email" id="email" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>">
            </div>
            <button class="primary-button">Enviar</button>
        </fieldset>
    </form>
</div>
