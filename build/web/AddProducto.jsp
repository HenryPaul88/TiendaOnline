<%-- 
    Document   : AddProducto
    Created on : 14-abr-2021, 17:32:35
    Author     : henry
--%>
<%@page import="domain.Imagen"%>
<%@page import="domain.Descuento"%>
<%@ page import ="domain.Familias"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/estilos.css">
        <title>Añadir Productos</title>



    </head>
    <body>

        <!-- header  -->
        <%@ include file="incluir/header.jsp"%>

        <!-- Formulario  -->
        <div class="container">
            <div class="login-box">

                <h1>Registro Producto</h1>
                <!-- 1 -->
                <form ACTION="InsertarProducto" method="POST">

                    <div class="col-sm-6">                 
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Nombre:(*)</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="inputGroup-sizing-default" name="nombre"
                                   style="border: solid blue"
                                   onblur="validarStringInside(this, 3, 100, nombreError)">
                        </div>
                        <label class="obligatorio" id="nombreError" for="nombre">
                            nombre: mas de 3 caracteres </label>
                    </div>

                    <!-- 1 -->

                    <div class="col-sm-6">                 
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Precio:(*)</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="inputGroup-sizing-default" name="precio"
                                   style="border: solid blue"
                                   onblur="validarStringInside(this, 3, 100, precioError)">
                        </div>
                        <label class="obligatorio" id="precioError" for="precio">
                            nombre: mas de 3 caracteres </label>
                    </div>

                    <!-- 1 -->

                    <div class="col-6">
                        <div class="form-row">
                            <div class="col">
                                <div class="input-group mb-4">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroup-sizing-default">Familias:(*)</span>
                                    </div>
                                    <select name="familias">

                                        <%

                                            List<Familias> listaFamilia = (List<Familias>) request.getAttribute("familias");

                                           
                                            for (int i = 0; i < listaFamilia.size(); i++) {

                                                if (listaFamilia != null) {

                                                    if (i == 0) {

                                        %>
                                        <option value=<%= listaFamilia.get(i).getCod_fam()%> selected> <%= listaFamilia.get(i).getNom_fam()%> </option>
                                        <% 	} else {
                                        %>
                                        <option value=<%= listaFamilia.get(i).getCod_fam()%> > <%= listaFamilia.get(i).getNom_fam()%> </option>
                                        <%
                                            }
                                        } else {
                                        %>
                                        <option>vacio</option>
                                        <%        }
                                            }
                                        %>
                                    </select>

                                </div>
                            </div>
                            <div class="col">
                                <div class="input-group mb-4">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroup-sizing-default">Descuentos:(*)</span>
                                    </div>

                                    <select name="Descuento">

                                        <%
                                            List<Descuento> listaDescuento = (List<Descuento>) request.getAttribute("descuentos");
                                                    
                                            for (int i = 0; i < listaDescuento.size(); i++) {

                                               
                                                    if (i == 0) {

                                        %>
                                        <option value=<%= listaDescuento.get(i).getCod_des()%> selected> <%= listaDescuento.get(i).getDescuento()%> </option>
                                        <% 	} else {
                                        %>
                                        <option value=<%= listaDescuento.get(i).getCod_des()%> > <%= listaDescuento.get(i).getDescuento()%> </option>
                                        <%
                                            }
                                       
                                            }
                                        %>
                                    </select>
                                </div>

                            </div>
                        </div>
                    </div>

                    <!-- 1 -->


                    <div class="col-sm-6">                 
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Imagen:(*)</span>
                            </div>

                            <select name="Imagen">

                                <%
                                    List<Imagen> listaImagen = (List<Imagen>) request.getAttribute("imagenes");
                                    
                                    for (int i = 0; i < listaImagen.size(); i++) {

                                        if (listaImagen.size() != 0) {
                                            if (i == 0) {

                                %>
                                <option value=<%= listaImagen.get(i).getCod_img()%> selected> <%= listaImagen.get(i).getRuta()%> </option>
                                <% 	} else {
                                %>
                                <option value=<%= listaImagen.get(i).getCod_img()%> > <%= listaImagen.get(i).getRuta()%> </option>
                                <%
                                    }
                                } else {
                                %>
                                <option value=1>vacio</option>
                                <%        }
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <!-- 1 -->

                    <div class="col-sm-6">                 
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Descrpcion:(*)</span>
                            </div>
                            <textarea id="observaciones" name="observaciones" rows="4" cols="150" style="border:solid blue"></textarea>
                        </div>

                    </div>


                    <!-- 1 -->

                    <div class="col-sm-4">
                        <p>Obligatorio (*)</p>
                        <input type="submit" value="Enviar">
                    </div>
                </form>

            </div>
        </div>


        <!-- footer  -->
        <%@ include file="incluir/footer.jsp"%>

    </body>

</html>
