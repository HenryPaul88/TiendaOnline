<%-- 
    Document   : IniciarSesion
    Created on : 14-abr-2021, 0:36:51
    Author     : henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="incluir/bootstrap.jsp"%>
        <link rel="stylesheet" href="CSS/login.css">
        <title>Iniciar Sesion</title>
        
    </head>

    <body>
        <!-- header  -->
        <%@ include file="incluir/header.jsp" %>
        <!-- formulario  -->

        <div class="login-box">

            <h1>Iniciar Sesion</h1>
            <form ACTION ="login" method="POST">

                <label for="usuario">Usuario</label>
                <input type="text" name="nombre" placeholder="Introducir usuario">

                <label for="password">Contrase&ntildea</label>
                <input type="password" name="contrasena" placeholder="Introducir contraseña">

                <label class="obligatorio" id="passError" for="error">
                    Usurio o contrase&ntildea incorrecta </label>

                <input type="submit" value="Entrar">
                <div class="preguntas">
                    <a href="#">Olvidaste tu contrase&ntildea?</a><br>
                    <a href="#">No tengo una cuenta?</a>
                </div>	
            </form>
        </div>

        <!-- footer  -->
        <%@ include file="incluir/footer.jsp" %>
    </body>

</html>
