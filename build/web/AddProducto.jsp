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
        <%@ include file="incluir/bootstrap.jsp"%>
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

                <p style="color: green"> ${Insertado} </p>

                <!-- 1 -->
                <form ACTION="InsertarProducto?accion=Guardar" method="POST" enctype="multipart/form-data">

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
                                   onblur="validarNUmeroDigitosInside(this, 1, 1000, precioError)">
                        </div>
                        <label class="obligatorio" id="precioError" for="precio">
                            Precio: numeros mayor que 1 y menos que 1000 </label>
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
                            <input type="file" name="foto" id="fotoid" class="form-control" >
                                   
                            
                        </div>
                    </div>

                    <!-- 1 -->

                    <div class="col-sm-6">                 
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Descripcion:(*)</span>
                            </div>
                            <textarea id="descripcion"  name="descripcion" rows="10" cols="250" style="border:solid blue"></textarea>
                        </div>

                    </div>


                    <!-- 1 -->

                    <div class="col-sm-4">
                        <p>Obligatorio (*)</p>

                        <div class="input-group mb-4">
                            <input class="btn btn-primary" type="submit" value="Guardar">
                        </div>

                    </div>
                </form>
            </div>
        </div>


        <!-- footer  -->
        <%@ include file="incluir/footer.jsp"%>

    </body>

</html>
