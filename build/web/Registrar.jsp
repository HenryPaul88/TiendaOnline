<%-- 
    Document   : Registrar
    Created on : 14-abr-2021, 0:18:24
    Author     : henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="incluir/bootstrap.jsp"%>
        <link rel="stylesheet" href="CSS/registrar.css">
        <link rel="stylesheet" href="CSS/estilos.css">
        <title>Registrar</title>

    <body>
        <!-- header  -->
        <%@ include file="incluir/header.jsp" %>
        <!-- formulario  -->
        <div class="login-box">

            <h1>Registro Usuario</h1>
            <!-- 1 -->
            <form ACTION ="InsertarCliente" method="POST">
                <div class="col-sm-12">
                    <div class="form-row">
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Nombre:(*)</span>
                                </div>
                                <input type="text" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="nombre" style="border:solid blue"
                                       onblur="validarStringInside(this, 3, 100, nombreError)">
                            </div>
                            <label class="obligatorio" id="nombreError" for="nombre">
                                nombre: mas de 3 caracteres </label>
                        </div>
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Apellidos:(*)</span>
                                </div>
                                <input type="text" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="apellidos" style="border:solid blue"
                                       onblur="validarStringInside(this, 3, 100, apellidosError)">
                            </div>
                            <label class="obligatorio" id="apellidosError" for="apellidos">
                                apellidos: mas de 3 caracteres </label>
                        </div>
                    </div>
                </div>
                <!-- 1 -->

                <div class="col-sm-12">
                    <div class="form-row">
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Telefono:(*)</span>
                                </div>
                                <input type="number" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="telefono" style="border:solid blue"
                                       onblur="validarTelefonoInside(this, 9, 9, telefonoError)">
                            </div>
                            <label class="obligatorio" id="telefonoError" for="telefono">
                                telefono:  9 digitos numericos y empieze por 6 7 o 9 </label>
                        </div>
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Email:(*)</span>
                                </div>
                                <input type="text" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="email" style="border:solid blue"
                                       onblur="validarEmailInside(this, emailError)">
                            </div>
                            <label class="obligatorio" id="emailError" for="email">
                                correo electrocino valido ejemplo@ejemplo.com </label>
                        </div>
                    </div>
                </div>

                <!-- 1 -->
                <div class="col-sm-12">
                    <div class="form-row">
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Direcci&oacuten:(*)</span>
                                </div>
                                <input type="text" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="direccion" style="border:solid blue"
                                       onblur="validarStringInside(this, 3, 100, direccionError)">
                            </div>
                            <label class="obligatorio" id="direccionError" for="direccion">
                                direccion: mas de 3 caracteres </label>
                        </div>
                        <div class="col">
                            <div class="input-group mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Contrase&ntildea:(*)</span>
                                </div>
                                <input type="text" class="form-control" aria-label="Default"
                                       aria-describedby="inputGroup-sizing-default" name="contrasena" style="border:solid blue"
                                       onblur="validarclaveInside(this, contrasenaError)">
                            </div>
                            <label class="obligatorio" id="contrasenaError" for="contrasena">
                                contrasena: mayuscula,miniscula,numero,caracter </label>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" name="captchaSpan">Captcha(*): <span id="num1"></span>
                                <span>+</span> <span id="num2"></span> </span>
                            <script type="text/javascript">
                                crearCaptcha();
                            </script>
                        </div>
                        <input type="text" class="form-control" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default" id="captcha" style="border:solid blue"
                               onblur="validarCaptchaIndise(this, captchaError)">
                    </div>
                    <label class="obligatorio" id="captchaError" for="captcha">
                        Error en la suma </label>
                </div>

                <!-- 1 -->
                <div class="col-sm-4">
                    <p>Obligatorio (*)</p>
                    <input type="submit" value="Enviar">
                </div>
            </form>

        </div>

        <!-- footer  -->
        <%@ include file="incluir/footer.jsp" %> 
        <script src="JS/menu.js"></script>
    </body>

</html>
